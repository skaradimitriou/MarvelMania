package com.stathis.marvelmania.models.stories

import android.os.Parcelable
import com.stathis.marvelmania.models.series.Series
import kotlinx.android.parcel.Parcelize

@Parcelize
class StoryDataContainer(
    val offset : Int,
    val limit : Int,
    val total : Int,
    val count : Int,
    val results : List<Story>
) : Parcelable