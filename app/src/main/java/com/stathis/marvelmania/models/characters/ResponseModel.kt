package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class ResponseModel(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<MarvelCharacter>
) : MarvelModel, Parcelable