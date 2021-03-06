package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ComicList(
    val available : Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items : List<MarvelComic>
) : Parcelable