package com.stathis.marvelmania.models.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ImageModel (
    val path : String,
    val extension : String
) : Parcelable