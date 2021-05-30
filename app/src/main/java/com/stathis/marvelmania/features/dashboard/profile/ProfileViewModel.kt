package com.stathis.marvelmania.features.dashboard.profile

import androidx.lifecycle.ViewModel
import com.stathis.marvelmania.adapters.FavoriteAdapter
import com.stathis.marvelmania.models.FavoriteModel

class ProfileViewModel : ViewModel() {

    val adapter = FavoriteAdapter()

    init {
        adapter.submitList(
            listOf(
                FavoriteModel("Favorite Marvel Characters"),
                FavoriteModel("Favorite Marvel Stories"),
                FavoriteModel("Favorite Marvel Events"),
                FavoriteModel("Favorite Marvel Comics"),
                FavoriteModel("Favorite Marvel Series")
            )
        )
    }
}
