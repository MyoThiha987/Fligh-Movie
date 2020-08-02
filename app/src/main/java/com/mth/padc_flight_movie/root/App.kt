package com.mth.padc_flight_movie.root

import android.app.Application
import android.content.Context
import android.util.Log
import com.mth.padc_flight_movie.data.models.MovieListModelImpl
import io.reactivex.plugins.RxJavaPlugins

class App : Application(){

    companion object{
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        RxJavaPlugins.setErrorHandler { throwable ->
            run {
                Log.d("RX error : ", "Rx error : ${throwable.localizedMessage}")
            }
        }
        MovieListModelImpl.initDatabase(context)
    }
}