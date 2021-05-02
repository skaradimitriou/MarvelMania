package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MarvelComic(
    val resourceUri : String,
    val name : String
) : Parcelable