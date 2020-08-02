package com.mth.padc_flight_movie.data.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.network.responses.MovieGenreResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

object  MovieListModelImpl : MovieListModel, BaseModel() {
    private val disposable = CompositeDisposable()

    override fun getPopularMovies(onError: (String) -> Unit) {
        mMovieApi.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it.results.map {
                    it.movieType = 1
                }
                saveAllPopularMovies(it.results)
            },{
                onError(it.localizedMessage ?: "Database Update Error")
            }).addTo(disposable)
    }

    @SuppressLint("CheckResult")
    override fun getMovieDetailByCastAndCrew(movieId: Int) : Observable<CastAndCrewVO> {
        return mMovieApi.getMovieDetailsByCastAndCrew(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

    override fun getTopRateMovies(onError: (String) -> Unit){
             mMovieApi.getTopRateMovie()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe({
                     it.results.map { it.movieType = 2 }
                     saveAllPopularMovies(it.results)
                 },{
                     onError(it.localizedMessage ?: "Database Update Error")
                 }).addTo(disposable)
    }

    override fun getMovieGenre(): Observable<MovieGenreResponse> {
        return mMovieApi.getMovieGenre()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveAllPopularMovies(movieList: List<MovieVO>) {
        movieDB.movieDao().saveAllMovies(movieList)
    }

    /*override fun saveAllBestMoiveCast(actorList: List<CastCrewVO>) {
        movieDB.actorDao().saveAllBestActors(actorList)
    }
    */

    override fun getAllPopularMoviesFromLocal(): LiveData<List<MovieVO>> = movieDB.movieDao().getPopularMovies(1)

    override fun getShowcaseMovieFromLocal(): LiveData<List<MovieVO>> = movieDB.movieDao().getShowCaseMovie(2)

    /*override fun getBestMovieCastFromLocal(): LiveData<List<CastCrewVO>> {
        return movieDB.actorDao().getAllBestActors()
    }

     */

}