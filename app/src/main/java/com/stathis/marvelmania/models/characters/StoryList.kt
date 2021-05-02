package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class StoryList(
    val available : Int,
    val collectionUri : String,
    val items : List<MarvelStory>,
    val returned : Int
) : Parcelable