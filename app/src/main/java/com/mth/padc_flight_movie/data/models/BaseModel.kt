package com.mth.padc_flight_movie.data.models

import android.content.Context
import com.mth.padc_flight_movie.BuildConfig
import com.mth.padc_flight_movie.network.MovieApi
import com.mth.padc_flight_movie.persistence.databases.MovieDB
import com.mth.padc_flight_movie.root.App
import com.mth.padc_flight_movie.utils.BASE_URL
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mMovieApi : MovieApi
    lateinit var movieDB: MovieDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)


        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            mOkHttpClient.networkInterceptors().add(httpLoggingInterceptor)
            mOkHttpClient.addInterceptor(ChuckInterceptor(App.context))
        }

        val mClient =mOkHttpClient.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mClient)
            .build()

        mMovieApi = retrofit.create(MovieApi::class.java)

    }

    fun initDatabase(context: Context){
        movieDB = MovieDB.getDatabase(context)
    }
}