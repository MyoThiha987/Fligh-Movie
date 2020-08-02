package com.mth.padc_flight_movie.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.utils.BASE_IMAGE_URL
import com.mth.padc_flight_movie.utils.dateFormat
import com.parassidhu.simpledate.toDateStandard
import kotlinx.android.synthetic.main.viewpod_popular_movies.view.imv_cover
import kotlinx.android.synthetic.main.viewpod_popular_movies.view.tv_movie_name
import kotlinx.android.synthetic.main.viewpop_top_rated_movies.view.*

class TopRateMovieViewPop @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr : Int = 0
) : ConstraintLayout(context,attributeSet,defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindData(movie: MovieVO) {
        tv_movie_name.text = movie.original_title
        tv_movie_date.text = movie.release_date?.dateFormat(movie.release_date!!).toDateStandard()
        Glide.with(context)
            .load(BASE_IMAGE_URL + movie.poster_path)
            .into(imv_cover)
    }
}