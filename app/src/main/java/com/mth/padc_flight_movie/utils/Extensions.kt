package com.mth.padc_flight_movie.utils

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.widget.TextView
import com.google.android.material.chip.Chip
import java.text.SimpleDateFormat
import java.util.*

fun Context.createChip (string: String) : Chip {

    val chip = Chip(this)
    chip.text = string
    chip.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
    chip.textSize = 12f
    chip.setTextColor(Color.WHITE)
    chip.setChipBackgroundColorResource(R.color.darker_gray)
    chip.isCheckable = false
    chip.isCheckedIconVisible = false
    return chip
}

fun Int.toHourAndMinute(num : Int) :String{
    var result = num * 1/60
    return "$result hours"
}

@SuppressLint("SimpleDateFormat")
fun String.dateFormat(string : String) : Date? {
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.parse(string)

}