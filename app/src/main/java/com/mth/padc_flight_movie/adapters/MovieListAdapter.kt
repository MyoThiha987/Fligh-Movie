package com.mth.padc_flight_movie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.delegates.onTapMovieItemDelegate
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.views.viewholders.BaseViewHolder
import com.mth.padc_flight_movie.views.viewholders.MovieListViewHolder

class MovieListAdapter(private val delegate: onTapMovieItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<MovieVO>,MovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpod_popular_movies,parent,false)
        return MovieListViewHolder(
            view,
            delegate
        )
    }
}