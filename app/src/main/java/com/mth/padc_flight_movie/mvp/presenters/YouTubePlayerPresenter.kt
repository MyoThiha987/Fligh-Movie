package com.mth.padc_flight_movie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_flight_movie.mvp.views.YouTubePlayerView

interface YouTubePlayerPresenter : BasePresenter<YouTubePlayerView> {
    fun onUIReady(lifecycleOwner: LifecycleOwner,movieId : Int)
}