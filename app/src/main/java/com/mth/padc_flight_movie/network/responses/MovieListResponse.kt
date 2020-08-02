package com.mth.padc_flight_movie.network.responses

import com.mth.padc_flight_movie.data.vos.MovieVO

data class MovieListResponse (
    var results : List<MovieVO>
)