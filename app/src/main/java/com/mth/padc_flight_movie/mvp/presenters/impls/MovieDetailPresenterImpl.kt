package com.mth.padc_flight_movie.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_flight_movie.data.models.MovieDetailModelImpl
import com.mth.padc_flight_movie.mvp.presenters.AbstractBasePresenter
import com.mth.padc_flight_movie.mvp.presenters.MovieDetailPresenter
import com.mth.padc_flight_movie.mvp.views.MovieDetailView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MovieDetailPresenterImpl : MovieDetailPresenter,AbstractBasePresenter<MovieDetailView>() {
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()
    private var mMovieDetailModel =
        MovieDetailModelImpl()

    override fun onUIReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        loadMovieDetailById(movieId)
        loadMovieDetailByCastAndCrew(movieId)
    }

    override fun onTapLike(id:Int) {
    }

    override fun onTapFavourite(id: Int) {

    }

    private fun loadMovieDetailById(movieId:Int){
        mMovieDetailModel.getMovieDetailById(movieId)
            .subscribe {
                mView?.showMovieDetailbyId(it)
            }.addTo(compositeDisposable)
    }

    private fun loadMovieDetailByCastAndCrew(movieId: Int){
        mMovieDetailModel.getMovieDetailByCastAndCrew(movieId)
            .subscribe {
                mView?.showMovieDetailByCastAndCrew(it)
            }.addTo(compositeDisposable)
    }
}