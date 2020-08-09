package com.mth.padc_flight_movie.data.models

import com.mth.padc_flight_movie.BuildConfig
import com.mth.padc_flight_movie.network.responses.MovieListResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieGenreModelImpl : MovieGenreModel,BaseModel() {
    override fun getDiscoverMovieByGenreId(genreId : Int): Observable<MovieListResponse> {
        return mMovieApi.getDiscoverMovieByGenreId(BuildConfig.API_KEY,genreId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}