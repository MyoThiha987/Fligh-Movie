package com.mth.padc_flight_movie.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.mth.padc_flight_movie.data.vos.MovieDetailVO
import com.mth.padc_flight_movie.utils.dateFormat
import com.parassidhu.simpledate.toDateStandard
import kotlinx.android.synthetic.main.viewpod_description.view.*

class DescriptionViewPod @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr : Int = 0) : LinearLayout(context,attributeSet,defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindData(movie : MovieDetailVO){
         movie.apply {
             tv_original_title_value.text = original_title
             tv_type_value.text = genres.map { it.name }.toString().removePrefix("[").removeSuffix("]")
             tv_production_value.text = production_countries.map { it.name }.toString().removePrefix("[").removeSuffix("]")
             tv_premiere_value.text = release_date.dateFormat(release_date).toDateStandard()
             tv_desc_value.text = overview
         }
    }



}