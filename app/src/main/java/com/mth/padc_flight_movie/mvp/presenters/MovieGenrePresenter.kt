package com.mth.padc_flight_movie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_flight_movie.delegates.onTapMovieItemDelegate
import com.mth.padc_flight_movie.mvp.views.MovieGenreView
import com.mth.shared.activities.mvp.presenters.BasePresenter

interface MovieGenrePresenter : BasePresenter<MovieGenreView> , onTapMovieItemDelegate {
    fun onUIReady(lifecycleOwner: LifecycleOwner,genreId : Int)

}