package com.stathis.marvelmania.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stathis.marvelmania.callbacks.DetailsClickListener
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.stories.StoryDataContainer
import com.stathis.marvelmania.util.getIncrediblePhoto
import kotlinx.android.synthetic.main.holder_character_results_item.view.*
import kotlinx.android.synthetic.main.holder_character_stories_item.view.*

class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var callback: DetailsClickListener

    fun presentData(data: MarvelModel, callback: DetailsClickListener) {
        this.callback = callback

        when (data) {
            is MarvelCharacter -> {
                val img = getIncrediblePhoto(data.thumbnail.path, data.thumbnail.extension)
                Glide.with(itemView).load(img).into(itemView.holder_char_details_img)

                itemView.holder_char_details_title.text = data.name
                itemView.holder_char_details_desc.text = data.description

                itemView.char_details_go_back.setOnClickListener {
                    callback.onBackBtnClick()
                }

                itemView.char_details_share.setOnClickListener {
                    callback.onShareBtnClick()
                }
            }

            is StoryDataContainer -> {
                val adapter = StoriesAdapter()
                itemView.char_stories_recycler.adapter = adapter
                adapter.submitList(data.results)
            }
        }
    }
}