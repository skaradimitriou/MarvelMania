package com.stathis.marvelmania.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.DiffUtilClass
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.stories.StoryDataContainer

class DetailsAdapter () : ListAdapter<MarvelModel, DetailsViewHolder>(DiffUtilClass<MarvelModel>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType,parent,false)
        return DetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)){
        is MarvelCharacter -> R.layout.holder_character_results_item
        is StoryDataContainer -> R.layout.holder_character_stories_item
        else -> R.layout.holder_empty_item
    }
}