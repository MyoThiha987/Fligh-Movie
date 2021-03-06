package com.mth.padc_flight_movie.views.viewholders

import android.view.View
import com.mth.padc_flight_movie.delegates.onTapMovieItemDelegate
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.views.viewpods.TopRateMovieViewPop
import com.mth.shared.activities.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.viewpod_popular_movies.view.imv_cover
import kotlinx.android.synthetic.main.viewpop_top_rated_movies.view.*

class TopRateMovieViewHolder(itemView : View,private val delegate: onTapMovieItemDelegate) : BaseViewHolder<MovieVO>(itemView) {

    private val mTopRateMovieViePod = itemView.viewpopTopRateMovie as TopRateMovieViewPop

    init {
        itemView.imv_cover.setOnClickListener {
            mData?.let {movie : MovieVO->
                delegate.onTapMovieItem(movie.id)
            }
        }
    }

    override fun bindData(data: MovieVO) {
        mData = data
        mData?.let {
            mTopRateMovieViePod.bindData(data)
        }
    }
}