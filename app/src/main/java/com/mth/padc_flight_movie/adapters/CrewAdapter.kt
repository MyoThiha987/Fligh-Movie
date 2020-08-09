package com.mth.padc_flight_movie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.delegates.onTapViewPodDelegate
import com.mth.padc_flight_movie.views.viewholders.NowPlayingMovieViewHolder
import com.mth.shared.activities.adapters.BaseRecyclerAdapter
import com.mth.shared.activities.views.viewholders.BaseViewHolder

class CrewAdapter(private val delegate:onTapViewPodDelegate) : BaseRecyclerAdapter<BaseViewHolder<CastCrewVO>, CastCrewVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CastCrewVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpod_now_playing_movie,parent,false)
        return NowPlayingMovieViewHolder(view,delegate)
    }
}