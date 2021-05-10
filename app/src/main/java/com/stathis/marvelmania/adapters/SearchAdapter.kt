package com.stathis.marvelmania.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.DiffUtilClass
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MarvelModel

class SearchAdapter(private val callback : ItemClickListener) : ListAdapter<MarvelModel, SearchViewHolder>(DiffUtilClass<MarvelModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_marvel_character_item,parent,false)
        return SearchViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}