package com.stathis.marvelmania.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.DiffUtilClass
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.comics.Comic

class MainScreenAdapter(private val callback: ItemClickListener) : ListAdapter<MarvelModel,MainScreenViewHolder>(DiffUtilClass<MarvelModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent,false)
        return MainScreenViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) = holder.bindData(getItem(position))

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)){
            is Comic -> R.layout.holder_marvel_comic_home_item
            else -> R.layout.holder_empty_item
        }
    }
}