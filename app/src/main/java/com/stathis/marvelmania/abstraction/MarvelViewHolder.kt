package com.stathis.marvelmania.abstraction

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MarvelModel

abstract class MarvelViewHolder(itemView: View, callback: ItemClickListener? = null) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener { callback?.onItemClick(it) }
    }

    fun bindData(data: MarvelModel) {
        itemView.tag = data
        presentData(data)
    }

    abstract fun presentData(data: MarvelModel)
}