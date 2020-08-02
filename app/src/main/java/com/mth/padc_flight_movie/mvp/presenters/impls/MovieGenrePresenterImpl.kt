package com.mth.padc_flight_movie.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_flight_movie.data.models.MovieGenreModelImpl
import com.mth.padc_flight_movie.mvp.presenters.AbstractBasePresenter
import com.mth.padc_flight_movie.mvp.presenters.MovieGenrePresenter
import com.mth.padc_flight_movie.mvp.views.MovieGenreView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MovieGenrePresenterImpl : MovieGenrePresenter , AbstractBasePresenter<MovieGenreView>() {
    private val mMovieGenreModel = MovieGenreModelImpl
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()
    override fun onUIReady(lifecycleOwner: LifecycleOwner,genreId : Int) {
        loadMovieListsByGenre(genreId)
    }

    override fun onTapMovieItem(id: Int) {
        mView?.navigateToMovieDetail(id)
    }

    private fun loadMovieListsByGenre(genreId: Int){
        mMovieGenreModel.getDiscoverMovieByGenreId(genreId)
            .subscribe {
                mView?.displayMovieByGenre(it.results)
            }.addTo(compositeDisposable)
    }
}