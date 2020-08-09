package com.mth.padc_flight_movie.mvp.views

import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.data.vos.GenreVO
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.shared.activities.mvp.views.BaseView

interface MovieListView : BaseView{
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun displayMovieList(list : List<MovieVO>)
    fun displayCastList(castlist : List<CastCrewVO>)
    fun displayTopRateMovieList(list : List<MovieVO>)
    fun displayMovieGenres(genreList : List<GenreVO>)
    fun navigateToMovieDetail(movieId : Int)
    fun navigatToVideoPlayerView(id:Int)

}