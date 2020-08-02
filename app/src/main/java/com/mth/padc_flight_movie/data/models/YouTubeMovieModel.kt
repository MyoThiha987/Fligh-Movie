package com.mth.padc_flight_movie.data.models

import com.mth.padc_flight_movie.network.responses.VideoResponse
import io.reactivex.Observable

interface YouTubeMovieModel {
    fun getYoutubeMovieById(movieId : Int) : Observable<VideoResponse>
}