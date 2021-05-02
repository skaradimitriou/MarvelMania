package com.stathis.marvelmania.models.series

import android.os.Parcelable
import com.stathis.marvelmania.models.characters.ImageModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class Series(
    val id : Int,
    val title : String,
    val description : String,
    val digitalId : Int,
    val modified : String,
    val format : String,
    val pageCount : Int,
    val thumbnail: ImageModel
) : Parcelable