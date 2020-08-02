package com.mth.padc_flight_movie.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.viewpod_now_playing_movie.view.*

class NowPlayingMovieViewPod @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr : Int = 0
) : ConstraintLayout(context,attributeSet,defStyleAttr){

    private var mDelegate : Delegate ?= null

    var isLike  = false
    var isFav = false

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun bindData(actor : CastCrewVO){
        tv_actor_name.text = actor.name
        Glide.with(context)
            .load(BASE_IMAGE_URL +actor.profile_path)
            .into(imv_cover)

        if (isLike) imvLike.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
        else imvLike.setImageResource(R.drawable.ic_baseline_thumb_up_24)

        if (isFav) imvFavourites.setImageResource(R.drawable.ic_baseline_favorite)
        else imvFavourites.setImageResource(R.drawable.ic_baseline_favorite)

    }

    fun setUpDelegate(delegate : Delegate){
        mDelegate = delegate
    }

    private fun setUpListener(){
        imvFavourites.setOnClickListener {
            mDelegate?.onTapFavourite(id)
            handleFavAction()

        }

        imvLike.setOnClickListener {
            mDelegate?.onTapLike(id)
            handleLikeAction()


        }
    }

    fun handleLikeAction(){
        if (!isLike){
            isLike = true
            imvLike.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
        }
        else{
            isLike = false
            imvLike.setImageResource(R.drawable.ic_baseline_thumb_up_24)
        }
    }

    fun handleFavAction(){
        if (!isFav){
            isFav = true
            imvFavourites.setImageResource(R.drawable.ic_baseline_favorite)
        }
        else{
            isFav = false
            imvFavourites.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }


    interface Delegate{
        fun onTapLike(id : Int)
        fun onTapFavourite(id : Int)
    }
}