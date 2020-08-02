package com.mth.padc_flight_movie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.data.vos.DummyVideoVO
import com.mth.padc_flight_movie.delegates.onTapSliderDelegate
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.layout_item_images.view.*

class SlidingAdapter(val context: Context,private val delegate: onTapSliderDelegate) : SliderViewAdapter<SlidingAdapter.SlidingViewHolder>() {
    var mData : MutableList<DummyVideoVO> = mutableListOf()

    fun addImageUrl(data : MutableList<DummyVideoVO>){
        mData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SlidingViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.layout_item_images,parent,false)
        return SlidingViewHolder(view,context,delegate)

    }

    override fun getCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(viewHolder: SlidingViewHolder?, position: Int) {
        viewHolder?.bindData(mData[position])
    }

    class SlidingViewHolder(private val itemView : View, private val context: Context,private val delegate : onTapSliderDelegate) : SliderViewAdapter.ViewHolder(itemView){

        private lateinit var mData: DummyVideoVO
        var image : AppCompatImageView ?= null

        init {
            itemView.setOnClickListener {
                delegate.onTapSliderItem(mData.id)
            }
        }

        fun bindData(videoVO : DummyVideoVO) {
            mData = videoVO
            image = itemView.imvImage as AppCompatImageView
            image?.let {
                Glide.with(itemView.context)
                    .load(videoVO.image_path)
                    .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).fitCenter())
                    .into(it)
            }
        }
    }
}