package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import kotlinx.android.parcel.Parcelize

@Parcelize
class MainResponseModel(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: ResponseModel
) : MarvelModel, Parcelable