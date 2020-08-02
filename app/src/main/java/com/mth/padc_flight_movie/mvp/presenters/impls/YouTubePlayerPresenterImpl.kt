package com.mth.padc_flight_movie.mvp.presenters.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LifecycleOwner
import com.mth.padc_flight_movie.data.models.YouTubeMovieModel
import com.mth.padc_flight_movie.data.models.YouTubeMovieModelImpl
import com.mth.padc_flight_movie.mvp.presenters.AbstractBasePresenter
import com.mth.padc_flight_movie.mvp.presenters.YouTubePlayerPresenter
import com.mth.padc_flight_movie.mvp.views.YouTubePlayerView

class YouTubePlayerPresenterImpl : YouTubePlayerPresenter,AbstractBasePresenter<YouTubePlayerView>() {
    private val mYoutubeModel : YouTubeMovieModel = YouTubeMovieModelImpl
    override fun onUIReady(lifecycleOwner: LifecycleOwner,movieId : Int) {
        getYoutubeById(lifecycleOwner,movieId)
    }

    @SuppressLint("CheckResult")
    fun getYoutubeById(lifecycleOwner: LifecycleOwner, movieId: Int){
        mYoutubeModel.getYoutubeMovieById(movieId)
            .subscribe {
                it.results.map {
                    it.key?.let { it1 -> mView?.playMovie(it1) }
                }
            }
    }
}