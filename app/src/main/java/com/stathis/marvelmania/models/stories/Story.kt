package com.stathis.marvelmania.models.stories

import android.os.Parcelable
import com.stathis.marvelmania.models.characters.ImageModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class Story(
    val id : Int,
    val title : String,
    val description : String,
    val digitalId : Int,
    val modified : String,
    val format : String,
    val pageCount : Int,
    val thumbnail: ImageModel
) : Parcelable