package com.stathis.marvelmania.adapters

import android.view.View
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.comics.Comic
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.holder_marvel_character_item.view.*
import kotlinx.android.synthetic.main.holder_marvel_comic_home_item.view.*

class MainScreenViewHolder(itemView : View,callback : ItemClickListener) : MarvelViewHolder(itemView,callback) {

    override fun presentData(data: MarvelModel) {
        when(data){
            is MarvelCharacter -> {
                itemView.home_hero_name.text = data.name
            }

            is Comic -> {
                val imagePath = "${data.thumbnail.path}/portrait_medium.${data.thumbnail.extension}"
                Glide.with(itemView).load(imagePath).placeholder(R.drawable.comic_background).into(itemView.home_comic_img)
            }
        }
    }
}
