package com.stathis.marvelmania.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.DiffUtilClass
import com.stathis.marvelmania.models.MarvelModel

class ComicAdapter : ListAdapter<MarvelModel, ComicViewHolder>(DiffUtilClass<MarvelModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_comic_hero_card_item,parent,false)
        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}