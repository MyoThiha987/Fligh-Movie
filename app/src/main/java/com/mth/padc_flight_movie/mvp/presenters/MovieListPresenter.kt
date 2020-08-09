package com.mth.padc_flight_movie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_flight_movie.delegates.onTapMovieItemDelegate
import com.mth.padc_flight_movie.delegates.onTapSliderDelegate
import com.mth.padc_flight_movie.delegates.onTapViewPodDelegate
import com.mth.padc_flight_movie.mvp.views.MovieListView
import com.mth.shared.activities.mvp.presenters.BasePresenter


interface MovieListPresenter : BasePresenter<MovieListView>,onTapMovieItemDelegate,onTapViewPodDelegate ,onTapSliderDelegate {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUIReady(lifecycleOwner: LifecycleOwner)
}