package com.mth.padc_flight_movie.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.adapters.*
import com.mth.padc_flight_movie.data.dummy.getSlideImage
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.data.vos.GenreVO
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.mvp.presenters.MovieListPresenter
import com.mth.padc_flight_movie.mvp.presenters.impls.MovieListPresenterImpl
import com.mth.padc_flight_movie.mvp.views.MovieListView
import com.mth.padc_flight_movie.root.App
import com.mth.shared.activities.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_item_movie_geners.*

class MainActivity : BaseActivity(), MovieListView {
    private lateinit var mMovieListAdapter: MovieListAdapter
    private lateinit var mNowPlayingMovieAdapter: NowPlayingMovieAdapter
    private lateinit var mTopRateMovieAdapter: TopRateMovieAdapter
    private lateinit var mMovieListPresenter: MovieListPresenter
    private lateinit var slidingAdapter: SlidingAdapter
    private lateinit var viewPagerAdapter: GenresPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpSwipeRefresh()
        setUpRecycler()
        setUpCastRecycler()
        setUpTopRateMovieRecycler()
        setUpImageSlider()
        setUpViewPager2WithTabLayout()
        mMovieListPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mMovieListPresenter = ViewModelProviders.of(this).get(MovieListPresenterImpl::class.java)
        mMovieListPresenter.initPresenter(this)
    }

    private fun setUpImageSlider() {
        slidingAdapter = SlidingAdapter(applicationContext,mMovieListPresenter)

        getSlideImage().map { it.image_path }
        slidingAdapter.addImageUrl(getSlideImage())
        imvSlider.sliderAdapter = slidingAdapter
    }

    private fun setUpSwipeRefresh() {
        srf.setOnRefreshListener {
            mMovieListPresenter.onSwipeRefresh(this)

        }
    }

    private fun setUpRecycler() {
        mMovieListAdapter = MovieListAdapter(mMovieListPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvPopularMovies.layoutManager = linearLayoutManager
        rvPopularMovies.adapter = mMovieListAdapter
    }

    private fun setUpCastRecycler() {
        mNowPlayingMovieAdapter = NowPlayingMovieAdapter(mMovieListPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvNowPlayMovies.layoutManager = linearLayoutManager
        rvNowPlayMovies.adapter = mNowPlayingMovieAdapter
    }

    private fun setUpTopRateMovieRecycler() {
        mTopRateMovieAdapter = TopRateMovieAdapter(mMovieListPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTopRatedMovies.layoutManager = linearLayoutManager
        rvTopRatedMovies.adapter = mTopRateMovieAdapter
    }

    override fun enableSwipeRefresh() {
        srf.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        srf.isRefreshing = false
    }

    override fun displayMovieList(list: List<MovieVO>) {
        mMovieListAdapter.setNewData(list.toMutableList())
    }

    override fun displayCastList(castlist: List<CastCrewVO>) {
        mNowPlayingMovieAdapter.setNewData(castlist.toMutableList())
    }

    override fun displayTopRateMovieList(list: List<MovieVO>) {
        mTopRateMovieAdapter.setNewData(list.toMutableList())
    }

    private fun setUpTabMediator(genreList: List<GenreVO>) {
        TabLayoutMediator(
            tab,
            viewpager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = genreList[position].name
            }).attach()
    }

    private fun setUpViewPager2WithTabLayout() {
        viewPagerAdapter = GenresPagerAdapter(this)
        viewpager.adapter = viewPagerAdapter
        tab.getTabAt(0)?.select()
        viewpager.isUserInputEnabled = false;
    }

    override fun displayMovieGenres(genreList: List<GenreVO>) {
        setUpTabMediator(genreList)
        viewPagerAdapter.setData(genreList)
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(App.context, movieId))
    }

    override fun navigatToVideoPlayerView(id: Int) {
        startActivity(YouTubePlayerActivity.newIntent(this,id))
    }
}

