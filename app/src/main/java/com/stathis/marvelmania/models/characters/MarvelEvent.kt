package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MarvelEvent(
    val resourceUri : String,
    val name : String
) : Parcelable