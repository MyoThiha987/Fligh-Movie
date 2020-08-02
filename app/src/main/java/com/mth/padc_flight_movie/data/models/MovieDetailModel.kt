package com.mth.padc_flight_movie.data.models

import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.MovieDetailVO
import io.reactivex.Observable

interface MovieDetailModel {
    fun getMovieDetailById(id : Int) : Observable<MovieDetailVO>
    fun getMovieDetailByCastAndCrew(id:Int) : Observable<CastAndCrewVO>
}