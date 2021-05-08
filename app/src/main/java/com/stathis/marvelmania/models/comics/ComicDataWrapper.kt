package com.stathis.marvelmania.models.comics

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class ComicDataWrapper (
    val code : Int,
    val status : String,
    val copyright : String,
    val data : ComicDataContainer
) : MarvelModel, Parcelable