package com.mth.padc_flight_movie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.activities.MovieDetailsActivity
import com.mth.padc_flight_movie.adapters.MovieListAdapter
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.mvp.presenters.MovieGenrePresenter
import com.mth.padc_flight_movie.mvp.presenters.impls.MovieGenrePresenterImpl
import com.mth.padc_flight_movie.mvp.views.MovieGenreView
import kotlinx.android.synthetic.main.fragment_genres.*


class GenresFragment() : Fragment(),MovieGenreView{
    private lateinit var mGenreAdaper: MovieListAdapter
    private lateinit var mGenrePresenter: MovieGenrePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_genres, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerView()

        mGenrePresenter.onUIReady(this,arguments!!.getInt(GENRE_ID))
    }

    private fun setUpPresenter(){
        mGenrePresenter = ViewModelProviders.of(this).get(MovieGenrePresenterImpl::class.java)
        mGenrePresenter.initPresenter(this)

    }

    private fun setUpRecyclerView(){
        mGenreAdaper = MovieListAdapter(mGenrePresenter)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvGenres.layoutManager = linearLayoutManager
        rvGenres.adapter = mGenreAdaper
    }

    override fun displayMovieByGenre(list: List<MovieVO>) {
        mGenreAdaper.setNewData(list.toMutableList())
    }

    override fun navigateToMovieDetail(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(context!!,movieId))
    }

    companion object{
        const val GENRE_ID ="genre_id"
        fun newInstance(genreId:Int) : GenresFragment{
            val fragment = GenresFragment()
            val bundle = Bundle().apply {
                putInt(GENRE_ID,genreId) }
            fragment.arguments = bundle
            return fragment

        }
    }
}