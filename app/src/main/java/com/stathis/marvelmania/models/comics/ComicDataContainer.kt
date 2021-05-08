package com.stathis.marvelmania.models.comics

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class ComicDataContainer(
    val offset : Int,
    val limit : Int,
    val total : Int,
    val count : Int,
    val results : List<Comic>
): MarvelModel, Parcelable