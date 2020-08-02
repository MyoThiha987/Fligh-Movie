package com.mth.padc_flight_movie.data.dummy

import com.mth.padc_flight_movie.data.vos.MovieVO

fun getDummyMovieList() : List<MovieVO>{
    val movieOne = MovieVO()
    movieOne.apply {
        id = 0
        original_title ="How are you?"
        poster_path = "https://vignette.wikia.nocookie.net/simpsons-restaurants/images/2/20/Spicy_Clucker.png/revision/latest?cb=20131125185837"
        vote_count = 100
    }

    val movieTwo = MovieVO()
    movieTwo.apply {
        id=1
        original_title ="How are you?"
        poster_path = "https://vignette.wikia.nocookie.net/simpsons-restaurants/images/2/20/Spicy_Clucker.png/revision/latest?cb=20131125185837"
        vote_count = 100
    }

    val movieThree = MovieVO()
    movieTwo.apply {
        id=2
        original_title ="How are you?"
        poster_path = "https://vignette.wikia.nocookie.net/simpsons-restaurants/images/2/20/Spicy_Clucker.png/revision/latest?cb=20131125185837"
        vote_count = 100
    }

    return listOf(movieOne,movieTwo,movieThree)
}