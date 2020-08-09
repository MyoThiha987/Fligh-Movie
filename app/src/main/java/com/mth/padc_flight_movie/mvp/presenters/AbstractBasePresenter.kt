package com.mth.padc_flight_movie.mvp.presenters

import androidx.lifecycle.ViewModel
import com.mth.shared.activities.mvp.presenters.BasePresenter
import com.mth.shared.activities.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>,ViewModel() {
    var mView : T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}