package com.stathis.marvelmania.adapters

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.util.TAG
import com.stathis.marvelmania.util.getMediumPhoto
import kotlinx.android.synthetic.main.holder_marvel_char_item.view.*
import kotlinx.android.synthetic.main.holder_marvel_character_item.view.*

class SearchViewHolder(itemView: View, callback: ItemClickListener) :
    MarvelViewHolder(itemView, callback) {

    override fun presentData(data: MarvelModel) {
        when (data) {
            is MarvelCharacter -> {
                val imagePath = getMediumPhoto(data.thumbnail.path, data.thumbnail.extension)

                Glide.with(itemView)
                    .load(imagePath)
                    .placeholder(R.drawable.comic_background)
                    .into(itemView.holder_character_img)

                itemView.home_hero_name.text = data.name
            }
        }
    }
}