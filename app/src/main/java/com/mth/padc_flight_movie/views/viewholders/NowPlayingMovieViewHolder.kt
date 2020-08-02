package com.mth.padc_flight_movie.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.delegates.onTapMovieItemDelegate
import com.mth.padc_flight_movie.delegates.onTapViewPodDelegate
import com.mth.padc_flight_movie.utils.BASE_IMAGE_URL
import com.mth.padc_flight_movie.views.viewpods.NowPlayingMovieViewPod
import kotlinx.android.synthetic.main.viewpod_now_playing_movie.view.*

class NowPlayingMovieViewHolder(itemView : View,private val delegate: onTapViewPodDelegate) : BaseViewHolder<CastCrewVO>(itemView) {

    private val mNowPlayingMovieViewPod = itemView.viewpodNowPlaying as NowPlayingMovieViewPod

    override fun bindData(data: CastCrewVO) {
        mData = data
        mData?.let {
            mNowPlayingMovieViewPod.bindData(it)
            mNowPlayingMovieViewPod.setUpDelegate(delegate)
        }
    }
}