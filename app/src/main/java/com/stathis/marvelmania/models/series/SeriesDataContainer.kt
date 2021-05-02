package com.stathis.marvelmania.models.series

import android.os.Parcelable
import com.stathis.marvelmania.models.events.Event
import kotlinx.android.parcel.Parcelize

@Parcelize
class SeriesDataContainer(
    val offset : Int,
    val limit : Int,
    val total : Int,
    val count : Int,
    val results : List<Series>
) : Parcelable