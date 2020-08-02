package com.mth.padc_flight_movie.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mth.padc_flight_movie.data.dummy.getDummyMovieList
import com.mth.padc_flight_movie.data.models.MockMovieListModelImpl
import com.mth.padc_flight_movie.data.models.MovieListModel
import com.mth.padc_flight_movie.data.models.MovieListModelImpl
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.mvp.presenters.impls.MovieListPresenterImpl
import com.mth.padc_flight_movie.mvp.views.MovieListView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MovieListPresenterImplTest {

    private lateinit var mPresenter: MovieListPresenterImpl

    @RelaxedMockK
    private lateinit var mView : MovieListView

    private lateinit var mMovieListModel : MovieListModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)
        MovieListModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieListModel = MockMovieListModelImpl
        mPresenter = MovieListPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieListModel
    }

    @Test
    fun onTapMovie_callNavigateToMovieDetails(){
        val movie = MovieVO()
        movie.apply {
            id = 0
            original_title = "Hello  Hello"
            poster_path = ""
            vote_count = 100
            mPresenter.onTapMovieItem(id)
            verify {
                mView.navigateToMovieDetail(id)
            }
        }
    }

    @Test
    fun onUIReady_callDisplayMovieList_callDisplayCountInCart(){
        val lifeCyclerOwner: LifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifeCyclerOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCyclerOwner.lifecycle).thenReturn(lifecycleRegistry)
        mPresenter.onUIReady(lifeCyclerOwner)
        verify {
            mView.displayMovieList(getDummyMovieList())
        }
    }

}