package com.eneselcuk.bookprojectexample.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("dogImage")
    fun ImageView.dog(imageUrl:String){
        Glide.with(context)
            .load(imageUrl)
            .fitCenter()
            .into(this)
    }
}