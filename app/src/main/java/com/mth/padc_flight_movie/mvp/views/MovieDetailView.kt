package com.mth.padc_flight_movie.mvp.views

import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.MovieDetailVO
import com.mth.shared.activities.mvp.views.BaseView

interface MovieDetailView : BaseView {
    fun showMovieDetailbyId(movie : MovieDetailVO)
    fun showMovieDetailByCastAndCrew(cast : CastAndCrewVO)
}