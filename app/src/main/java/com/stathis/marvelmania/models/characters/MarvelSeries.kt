package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MarvelSeries(
    val id : Int,
    val title : String
) : Parcelable