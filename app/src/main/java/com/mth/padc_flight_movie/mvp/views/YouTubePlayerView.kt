package com.mth.padc_flight_movie.mvp.views

import com.mth.shared.activities.mvp.views.BaseView

interface YouTubePlayerView : BaseView {
    fun playMovie(data : String)
}