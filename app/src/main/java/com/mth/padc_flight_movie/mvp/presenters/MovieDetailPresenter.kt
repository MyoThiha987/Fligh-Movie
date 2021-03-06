package com.mth.padc_flight_movie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_flight_movie.delegates.onTapViewPodDelegate
import com.mth.padc_flight_movie.mvp.views.MovieDetailView
import com.mth.shared.activities.mvp.presenters.BasePresenter

interface MovieDetailPresenter : BasePresenter<MovieDetailView>,onTapViewPodDelegate{
    fun onUIReady(lifecycleOwner: LifecycleOwner,movieId : Int)
}