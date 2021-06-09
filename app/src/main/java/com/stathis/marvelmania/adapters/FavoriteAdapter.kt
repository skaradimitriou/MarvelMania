package com.stathis.marvelmania.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.DiffUtilClass
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MarvelModel

class FavoriteAdapter(private val callback: ItemClickListener) :
    ListAdapter<MarvelModel, FavoriteViewHolder>(DiffUtilClass<MarvelModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_favorite_categories, parent, false)
        return FavoriteViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}