package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class MarvelCharacter(
    val id: Int,
    val name: String,
    val issueDescription: Int,
    val description : String,
    val format: String,
    val thumbnail: ImageModel,
    val comics: ComicList,
    val stories: StoryList,
    val events: EventList,
    val series: MarvelSeries,
    val urls: List<MarvelUrl>
) : MarvelModel, Parcelable