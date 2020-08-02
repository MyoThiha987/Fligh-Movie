package com.mth.padc_flight_movie.mvp.presenters

import com.mth.padc_flight_movie.mvp.views.BaseView

interface BasePresenter<T:BaseView> {
    fun initPresenter(view : T)
}