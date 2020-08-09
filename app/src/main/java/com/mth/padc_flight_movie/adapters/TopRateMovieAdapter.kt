package com.mth.padc_flight_movie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.delegates.onTapMovieItemDelegate
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.views.viewholders.TopRateMovieViewHolder
import com.mth.shared.activities.adapters.BaseRecyclerAdapter
import com.mth.shared.activities.views.viewholders.BaseViewHolder

class TopRateMovieAdapter(private val delegate: onTapMovieItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<MovieVO>, MovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieVO> {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.viewpop_top_rated_movies,parent,false)
        return TopRateMovieViewHolder(
            view,
            delegate
        )
    }
}