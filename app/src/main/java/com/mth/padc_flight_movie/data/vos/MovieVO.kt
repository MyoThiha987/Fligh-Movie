package com.mth.padc_flight_movie.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "movie")
data class MovieVO(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("original_title")
    var original_title: String ?="" ,
    @SerializedName("overview")
    var overview: String ?="null",
    @SerializedName("poster_path")
    var poster_path: String?="",
    @SerializedName("vote_average")
    var vote_average: Double ?= 0.0,
    @SerializedName("vote_count")
    var vote_count: Int =0,
    @SerializedName("release_date")
    var release_date : String?= "",
    @ColumnInfo(name = "movieType")
    var movieType : Int = 0
)
