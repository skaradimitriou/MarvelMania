package com.stathis.marvelmania.adapters

import android.view.View
import com.bumptech.glide.Glide
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.comics.Comic
import kotlinx.android.synthetic.main.holder_comic_hero_card_item.view.*

class ComicViewHolder(itemView: View) : MarvelViewHolder(itemView) {

    override fun presentData(data: MarvelModel) {
        when (data) {
            is Comic -> {
                val imagePath = "${data.thumbnail.path}/landscape_large.${data.thumbnail.extension}"
                Glide.with(itemView).load(imagePath).into(itemView.comic_hero_img)
            }
        }
    }
}