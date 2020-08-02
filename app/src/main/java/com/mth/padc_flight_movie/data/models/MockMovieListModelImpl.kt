package com.mth.padc_flight_movie.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mth.padc_flight_movie.data.dummy.getDummyMovieList
import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.network.responses.MovieGenreResponse
import io.reactivex.Observable

object MockMovieListModelImpl : MovieListModel {

    var movieList : MutableList<MovieVO> = mutableListOf()

    override fun getPopularMovies(onError: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getMovieDetailByCastAndCrew(movieId: Int): Observable<CastAndCrewVO> {
        TODO("Not yet implemented")
    }

    override fun getTopRateMovies(onError: (String) -> Unit) {
       TODO("Not yet implemented")
    }

    override fun getMovieGenre(): Observable<MovieGenreResponse> {
        TODO("Not yet implemented")
    }

    override fun saveAllPopularMovies(movieList: List<MovieVO>) {
        //TODO("Not yet implemented")
    }

    override fun getAllPopularMoviesFromLocal(): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovieList())
        return liveData
    }

    override fun getShowcaseMovieFromLocal(): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovieList())
        return liveData
    }
}