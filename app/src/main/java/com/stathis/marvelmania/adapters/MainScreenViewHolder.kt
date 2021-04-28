package com.stathis.marvelmania.adapters

import android.view.View
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MarvelCharacter
import com.stathis.marvelmania.models.MarvelModel
import kotlinx.android.synthetic.main.holder_marvel_character_item.view.*

class MainScreenViewHolder(itemView : View,callback : ItemClickListener) : MarvelViewHolder(itemView,callback) {

    override fun presentData(data: MarvelModel) {
        when(data){
            is MarvelCharacter -> {
                itemView.home_hero_name.text = data.title
            }
        }
    }
}
