package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MarvelUrl (
    val type : String,
    val url : String
) : Parcelable