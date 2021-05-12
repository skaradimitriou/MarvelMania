package com.stathis.marvelmania.adapters

import android.view.View
import com.bumptech.glide.Glide
import com.stathis.marvelmania.abstraction.MarvelViewHolder
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.stories.Story
import com.stathis.marvelmania.util.getMediumPhoto
import kotlinx.android.synthetic.main.holder_story_item.view.*

class StoriesViewHolder(itemView: View) : MarvelViewHolder(itemView) {

    override fun presentData(data: MarvelModel) {
        when (data) {
            is Story -> {
                val imagePath = getMediumPhoto(data.thumbnail.path, data.thumbnail.extension)
                Glide.with(itemView).load(imagePath).into(itemView.story_img)
            }
        }
    }
}
