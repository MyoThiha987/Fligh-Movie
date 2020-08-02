package com.mth.padc_flight_movie.delegates

import com.mth.padc_flight_movie.views.viewpods.NowPlayingMovieViewPod

interface onTapMovieItemDelegate    {
    fun onTapMovieItem(id : Int)
}

interface onTapViewPodDelegate : NowPlayingMovieViewPod.Delegate
interface onTapSliderDelegate {
    fun onTapSliderItem(id: Int)
}