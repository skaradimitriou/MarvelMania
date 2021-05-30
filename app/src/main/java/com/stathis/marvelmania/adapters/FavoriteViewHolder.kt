package com.stathis.marvelmania.adapters

import android.view.View
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.models.FavoriteModel
import com.stathis.marvelmania.models.MarvelModel
import kotlinx.android.synthetic.main.holder_favorite_categories.view.*

class FavoriteViewHolder(itemView: View) : MarvelViewHolder(itemView) {

    override fun presentData(data: MarvelModel) {
        when (data) {
            is FavoriteModel -> {
                itemView.favorite_caterory_header.text = data.name
            }
        }
    }
}
