package com.mth.padc_flight_movie.data.models

import com.mth.padc_flight_movie.network.responses.VideoResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object YouTubeMovieModelImpl : YouTubeMovieModel,BaseModel() {
    override fun getYoutubeMovieById(movieId: Int) : Observable<VideoResponse> {
        return mMovieApi.getMoviesById(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}