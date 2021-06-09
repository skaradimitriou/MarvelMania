package com.stathis.marvelmania.features.dashboard.profile

import com.stathis.marvelmania.models.FavoriteModel

interface ProfileClickListener {

    fun onFavoriteCategoryClick(fav : FavoriteModel)
}
