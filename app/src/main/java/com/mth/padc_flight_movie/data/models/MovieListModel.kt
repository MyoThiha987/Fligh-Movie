package com.mth.padc_flight_movie.data.models

import androidx.lifecycle.LiveData
import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.network.responses.MovieGenreResponse
import io.reactivex.Observable

interface MovieListModel {
    fun getPopularMovies(onError:(String)->Unit)
    fun getMovieDetailByCastAndCrew(movieId : Int) :Observable<CastAndCrewVO>
    fun getTopRateMovies(onError: (String) -> Unit)
    fun getMovieGenre() : Observable<MovieGenreResponse>
    //From DB
    fun saveAllPopularMovies(movieList : List<MovieVO>)
    fun getAllPopularMoviesFromLocal() : LiveData<List<MovieVO>>
    //fun saveAllBestMoiveCast(actorList : List<CastCrewVO>)
    //fun getBestMovieCastFromLocal() : LiveData<List<CastCrewVO>>
    fun getShowcaseMovieFromLocal() : LiveData<List<MovieVO>>

}