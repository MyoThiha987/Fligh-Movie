package com.mth.padc_flight_movie.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mth.padc_flight_movie.data.vos.MovieVO

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMovies(movies : List<MovieVO>)

    @Query("select * from movie where movieType = :movieType")
    fun getPopularMovies(movieType:Int) : LiveData<List<MovieVO>>

    @Query("select * from movie where movieType = :movieType")
    fun getShowCaseMovie(movieType: Int) : LiveData<List<MovieVO>>

    @Query("delete from movie")
    fun deleteAllMovies()

    @Query("SELECT * FROM movie WHERE id = :id")
    fun findMovieById(id : Int) : LiveData<MovieVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(movie : MovieVO)
}