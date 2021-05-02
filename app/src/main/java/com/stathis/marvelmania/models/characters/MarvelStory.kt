package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MarvelStory(
    val resourceUri : String,
    val name : String,
    val type : String
) : Parcelable
