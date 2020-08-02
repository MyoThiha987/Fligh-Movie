package com.mth.padc_flight_movie.data.models

import com.mth.padc_flight_movie.network.responses.MovieListResponse
import com.mth.padc_flight_movie.utils.API_KEY
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieGenreModelImpl : MovieGenreModel,BaseModel() {
    override fun getDiscoverMovieByGenreId(genreId : Int): Observable<MovieListResponse> {
        return mMovieApi.getDiscoverMovieByGenreId(API_KEY,genreId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}