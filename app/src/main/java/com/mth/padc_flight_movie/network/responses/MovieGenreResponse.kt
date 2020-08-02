package com.mth.padc_flight_movie.network.responses

import com.google.gson.annotations.SerializedName
import com.mth.padc_flight_movie.data.vos.GenreVO

data class MovieGenreResponse(
    @SerializedName("genres")
    var genres : List<GenreVO>
)