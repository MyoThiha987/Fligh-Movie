package com.mth.padc_flight_movie.persistence.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.persistence.daos.ActorsDao
import com.mth.padc_flight_movie.persistence.daos.MovieDao

@Database(entities = [MovieVO::class,CastCrewVO::class],version = 2,exportSchema = false)
abstract class MovieDB : RoomDatabase(){

    abstract fun movieDao (): MovieDao
    abstract fun actorDao() : ActorsDao

    companion object{
        private const val DB_NAME = "movies.db"
        private var INSTANCE : MovieDB ?= null

        fun getDatabase(context: Context) : MovieDB{
            INSTANCE = Room.databaseBuilder(context,MovieDB::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            return INSTANCE as MovieDB
        }
    }
}