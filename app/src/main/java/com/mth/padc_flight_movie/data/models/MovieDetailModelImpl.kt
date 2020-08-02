package com.mth.padc_flight_movie.data.models

import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.MovieDetailVO
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailModelImpl : MovieDetailModel, BaseModel() {
    override fun getMovieDetailById(id: Int): Observable<MovieDetailVO> {
        return mMovieApi.getMovieDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getMovieDetailByCastAndCrew(id: Int): Observable<CastAndCrewVO> {
        return mMovieApi.getMovieDetailsByCastAndCrew(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}