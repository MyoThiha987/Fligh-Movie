package com.mth.padc_flight_movie.data.vos

import com.google.gson.annotations.SerializedName

data class CastAndCrewVO(
    @SerializedName("cast")
    var cast: List<CastCrewVO>,
    @SerializedName("crew")
    var crew: List<CastCrewVO>

)