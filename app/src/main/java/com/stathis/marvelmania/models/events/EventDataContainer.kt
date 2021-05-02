package com.stathis.marvelmania.models.events

import android.os.Parcelable
import com.stathis.marvelmania.models.comics.Comic
import kotlinx.android.parcel.Parcelize

@Parcelize
class EventDataContainer(
    val offset : Int,
    val limit : Int,
    val total : Int,
    val count : Int,
    val results : List<Event>
) : Parcelable