package com.mth.padc_flight_movie.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mth.padc_flight_movie.fragments.GenresFragment
import com.mth.padc_flight_movie.data.vos.GenreVO

abstract class BaseViewPagerAdapter(fragmentActivity : FragmentActivity) : FragmentStateAdapter(fragmentActivity)

class GenresPagerAdapter(fragmentActivity: FragmentActivity) : BaseViewPagerAdapter(fragmentActivity) {
    private var genreList:List<Any> = emptyList()
    override fun getItemCount(): Int = genreList.size

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> GenresFragment.newInstance((genreList[position] as GenreVO).id)
            else -> GenresFragment.newInstance((genreList[position] as GenreVO).id)
        }
    }

    fun setData(data: List<Any>) {
        genreList = data
        notifyDataSetChanged()
    }
}

