package com.stathis.marvelmania.adapters

import android.view.View
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.characters.MarvelCharacter
import kotlinx.android.synthetic.main.holder_marvel_char_item.view.*

class SearchViewHolder(itemView: View,callback : ItemClickListener) : MarvelViewHolder(itemView,callback) {

    override fun presentData(data: MarvelModel) {
        when (data) {
            is MarvelCharacter -> {
                itemView.holder_character_name.text = data.name
            }
        }
    }
}