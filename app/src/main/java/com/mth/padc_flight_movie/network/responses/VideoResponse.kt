package com.mth.padc_flight_movie.network.responses

import com.google.gson.annotations.SerializedName
import com.mth.padc_flight_movie.data.vos.VideoVO

data class VideoResponse(
    @SerializedName("results")
    var results : List<VideoVO> = listOf()
)