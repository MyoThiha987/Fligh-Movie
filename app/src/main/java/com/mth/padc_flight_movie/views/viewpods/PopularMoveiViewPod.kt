package com.mth.padc_flight_movie.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.mth.padc_flight_movie.data.vos.MovieVO
import com.mth.padc_flight_movie.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.viewpod_popular_movies.view.*

class PopularMoveiViewPod @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr : Int = 0
) : ConstraintLayout(context,attributeSet,defStyleAttr){

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindData(movie : MovieVO){
        tv_movie_name.text = movie.original_title
        tv_rate_count.text = movie.vote_count.toString()
        ratingBar.rating = movie.vote_average!!.toFloat()
        Glide.with(context)
            .load(BASE_IMAGE_URL+movie.poster_path)
            .into(imv_cover)
    }
}