package com.mth.shared.activities.mvp.presenters

import com.mth.shared.activities.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view : T)
}