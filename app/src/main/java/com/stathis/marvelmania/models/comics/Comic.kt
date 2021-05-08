package com.stathis.marvelmania.models.comics

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.characters.ImageModel
import com.stathis.marvelmania.models.characters.MarvelCharacter
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class Comic (
    val id : Int,
    val digitalId : Int,
    val title : String,
    val description : String,
    val modified : String,
    val format : String,
    val pageCount : Int,
    val thumbnail: ImageModel
): MarvelModel, Parcelable