package com.stathis.marvelmania.models.stories

import android.os.Parcelable
import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.series.SeriesDataContainer
import kotlinx.android.parcel.Parcelize

@Parcelize
class StoryDataWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: StoryDataContainer
) : MarvelModel, Parcelable