package com.mth.padc_flight_movie.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.persistence.daos.MovieDao
import com.mth.padc_flight_movie.persistence.databases.MovieDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var burgerDao : MovieDao
    private lateinit var db : MovieDB


    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,MovieDB::class.java).build()
        burgerDao = db.movieDao()
    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest(){
        val movieOne = MovieVO()
        movieOne.apply {
            id =0
            original_title = "Chicken "
            poster_path = "https://vignette.wikia.nocookie.net/simpsons-restaurants/images/2/20/Spicy_Clucker.png/revision/latest?cb=20131125185837"
        }
        burgerDao.saveMovie(movieOne)
        assert(burgerDao.findMovieById(movieOne.id).value?.id == movieOne.id)
    }
}