package com.mth.padc_flight_movie.data.models

import com.mth.padc_flight_movie.network.responses.MovieListResponse
import io.reactivex.Observable

interface MovieGenreModel {
    fun getDiscoverMovieByGenreId(genreId : Int) : Observable<MovieListResponse>
}