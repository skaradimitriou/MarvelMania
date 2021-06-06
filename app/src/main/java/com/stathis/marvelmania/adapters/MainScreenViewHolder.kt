package com.stathis.marvelmania.adapters

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.comics.Comic
import com.stathis.marvelmania.models.events.Event
import com.stathis.marvelmania.models.stories.Story
import com.stathis.marvelmania.util.TAG
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.holder_marvel_character_item.view.*
import kotlinx.android.synthetic.main.holder_marvel_comic_home_item.view.*
import kotlinx.android.synthetic.main.holder_marvel_event_home_item.view.*
import kotlinx.android.synthetic.main.holder_marvel_hero_item_row.view.*
import kotlinx.android.synthetic.main.holder_marvel_story_home_item.view.*

class MainScreenViewHolder(itemView: View, callback: ItemClickListener) :
    MarvelViewHolder(itemView, callback) {

    override fun presentData(data: MarvelModel) {
        when (data) {
            is Comic -> {
                val imagePath = "${data.thumbnail.path}/portrait_medium.${data.thumbnail.extension}"
                Log.d(TAG, imagePath)
                Glide.with(itemView).load(imagePath).into(itemView.home_comic_img)
            }

            is MarvelCharacter -> {
                val imagePath = "${data.thumbnail.path}/portrait_medium.${data.thumbnail.extension}"
                Log.d(TAG, imagePath)
                Glide.with(itemView).load(imagePath).into(itemView.home_hero_img)
            }

            is Event -> {
                val imagePath = "${data.thumbnail.path}/portrait_medium.${data.thumbnail.extension}"
                Log.d(TAG, imagePath)
                Glide.with(itemView).load(imagePath).into(itemView.home_event_img)
            }

            is Story -> {
                val imagePath = "${data.thumbnail.path}/portrait_medium.${data.thumbnail.extension}"
                Log.d(TAG, imagePath)
                Glide.with(itemView).load(imagePath).into(itemView.home_story_img)
            }
        }
    }
}
