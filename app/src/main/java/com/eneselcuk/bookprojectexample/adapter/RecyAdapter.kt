package com.eneselcuk.bookprojectexample.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eneselcuk.bookprojectexample.R
import com.eneselcuk.bookprojectexample.databinding.ItemAlldogBinding
import javax.inject.Inject


class RecyAdapter  @Inject constructor(): RecyclerView.Adapter<ViewHolder>() {

    var dogList : List<String>? = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged() 
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(DataBindingUtil.inflate<ItemAlldogBinding>(
          LayoutInflater.from(parent.context),
          R.layout.item_alldog,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookPosition = dogList?.get(position)
        holder.dogBind(bookPosition)
    }

    override fun getItemCount(): Int {
        return dogList?.size!!
    }

}