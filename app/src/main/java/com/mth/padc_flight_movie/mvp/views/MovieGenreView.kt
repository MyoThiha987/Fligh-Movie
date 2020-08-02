package com.mth.padc_flight_movie.mvp.views

import com.mth.padc_flight_movie.data.vos.MovieVO

interface MovieGenreView : BaseView {
    fun displayMovieByGenre(list : List<MovieVO>)
    fun navigateToMovieDetail(movieId : Int)
}