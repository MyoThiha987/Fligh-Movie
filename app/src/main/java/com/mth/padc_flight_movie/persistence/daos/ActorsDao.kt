package com.mth.padc_flight_movie.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mth.padc_flight_movie.data.vos.CastCrewVO

@Dao
interface ActorsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllBestActors(actorList: List<CastCrewVO>)

    @Query("select * from actors")
    fun getAllBestActors() : LiveData<List<CastCrewVO>>

    @Query("delete from actors")
    fun deleteAllBestActors()
}