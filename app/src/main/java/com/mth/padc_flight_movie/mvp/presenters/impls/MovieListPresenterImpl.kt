package com.mth.padc_flight_movie.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mth.padc_flight_movie.data.models.MovieListModel
import com.mth.padc_flight_movie.data.models.MovieListModelImpl
import com.mth.padc_flight_movie.mvp.presenters.AbstractBasePresenter
import com.mth.padc_flight_movie.mvp.presenters.MovieListPresenter
import com.mth.padc_flight_movie.mvp.views.MovieListView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MovieListPresenterImpl : MovieListPresenter, AbstractBasePresenter<MovieListView>() {
     var mMovieModel : MovieListModel= MovieListModelImpl
    private val disposable = CompositeDisposable()
    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        loadMoviesFromDatabase(lifecycleOwner)
        loadShowcaseMovieFromDatabase(lifecycleOwner)
        loadCastFromApi()
        loadMovieGenresFromApi()
    }

    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
        loadShowcaseMovieFromDatabase(lifecycleOwner)
        loadMoviesFromDatabase(lifecycleOwner)
        loadCastFromApi()
        loadMoviesFromApi()
        loadCastFromApi()
        loadShowCaseMovieFromApi()
        loadMovieGenresFromApi()
    }

    override fun onTapMovieItem(id: Int) {
        mView?.navigateToMovieDetail(id)
    }

    override fun onTapLike(id: Int) {
        //
    }

    override fun onTapFavourite(id: Int) {
        //

    }

    override fun onTapSliderItem(id: Int) {
        mView?.navigatToVideoPlayerView(id)
    }

    private fun loadMoviesFromApi(){
        mMovieModel.getPopularMovies(onError = {})
    }

    private fun loadMoviesFromDatabase(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mMovieModel.getAllPopularMoviesFromLocal()
            .observe(lifecycleOwner, Observer {
                mView?.disableSwipeRefresh()
                mView?.displayMovieList(it)
            })
    }

    private fun loadMovieGenresFromApi(){
        mView?.enableSwipeRefresh()
        mMovieModel.getMovieGenre()
            .subscribe ({
                mView?.disableSwipeRefresh()
                mView?.displayMovieGenres(it.genres.toMutableList())
            },{
                mView?.disableSwipeRefresh()
            })
            .addTo(disposable)
    }

    private fun loadShowCaseMovieFromApi(){
        mMovieModel.getTopRateMovies(onError = {})
    }

    private fun loadShowcaseMovieFromDatabase(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mMovieModel.getShowcaseMovieFromLocal()
            .observe(lifecycleOwner, Observer {
                mView?.disableSwipeRefresh()
                mView?.displayTopRateMovieList(it)
            })
    }

    private fun loadCastFromApi(){
        mView?.enableSwipeRefresh()
        mMovieModel.getMovieDetailByCastAndCrew(516486)
            .subscribe {
                mView?.disableSwipeRefresh()
                mView?.displayCastList(it.cast)

            }.addTo(disposable)

    }

    /*private fun loadCastFromLocal(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        mMovieModel.getBestMovieCastFromLocal()
            .observe(lifecycleOwner, Observer {
                mView?.disableSwipeRefresh()
                mView?.displayCastList(it)
            })
    }

     */
}
