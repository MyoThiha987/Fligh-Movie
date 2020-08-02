package com.mth.padc_flight_movie.data.vos

import com.google.gson.annotations.SerializedName

data class VideoVO(
    @SerializedName("key")
    val key : String ?= null
)