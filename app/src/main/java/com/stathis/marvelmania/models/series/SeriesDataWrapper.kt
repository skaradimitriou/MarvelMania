package com.stathis.marvelmania.models.series

import android.os.Parcelable
import com.stathis.marvelmania.models.events.EventDataContainer
import kotlinx.android.parcel.Parcelize

@Parcelize
class SeriesDataWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: SeriesDataContainer
) : Parcelable