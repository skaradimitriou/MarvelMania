package com.stathis.marvelmania.models.events

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.comics.ComicDataContainer
import kotlinx.android.parcel.Parcelize

@Parcelize
class EventDataWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: EventDataContainer
) : Parcelable, MarvelModel