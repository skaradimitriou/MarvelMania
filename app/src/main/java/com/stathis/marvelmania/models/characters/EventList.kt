package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class EventList(
    val available : Int,
    val collectionUri : String,
    val items : List<MarvelEvent>,
    val returned : Int
) : Parcelable