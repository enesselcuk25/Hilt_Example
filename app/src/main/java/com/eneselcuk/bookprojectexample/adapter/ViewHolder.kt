package com.eneselcuk.bookprojectexample.adapter

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.eneselcuk.bookprojectexample.R
import com.eneselcuk.bookprojectexample.databinding.ItemAlldogBinding

class ViewHolder(private val binding: ItemAlldogBinding):RecyclerView.ViewHolder(binding.root) {

    fun dogBind(
        dogList:String?
    ){
      binding.dog = dogList
       binding.itemDog.animation = AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation)
    }
}