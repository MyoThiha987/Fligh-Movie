package com.mth.padc_flight_movie.views.viewholders

import android.view.View
import com.mth.padc_flight_movie.delegates.onTapMovieItemDelegate
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.views.viewpods.PopularMoveiViewPod
import kotlinx.android.synthetic.main.viewpod_popular_movies.view.*
import kotlinx.android.synthetic.main.viewpod_popular_movies.view.imv_cover

class MovieListViewHolder(itemView : View ,private val delegate: onTapMovieItemDelegate) : BaseViewHolder<MovieVO>(itemView) {
    private val mPopularViewPod = itemView.viewpodPopular as PopularMoveiViewPod
    init {
        itemView.imv_cover.setOnClickListener {
            mData?.let {movie : MovieVO->
                delegate.onTapMovieItem(movie.id)
            }
        }
    }
    override fun bindData(data: MovieVO) {
        mData = data
        mData?.let { mPopularViewPod.bindData(it) }
    }
}