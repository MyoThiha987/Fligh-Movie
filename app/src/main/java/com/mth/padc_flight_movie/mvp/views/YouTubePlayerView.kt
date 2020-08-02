package com.mth.padc_flight_movie.mvp.views

import com.mth.padc_flight_movie.data.vos.VideoVO

interface YouTubePlayerView : BaseView {
    fun playMovie(data : String)
}