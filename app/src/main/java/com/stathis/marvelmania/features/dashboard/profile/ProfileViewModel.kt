package com.stathis.marvelmania.features.dashboard.profile

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.stathis.marvelmania.adapters.FavoriteAdapter
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.FavoriteModel
import com.stathis.marvelmania.models.User
import com.stathis.marvelmania.util.TAG

class ProfileViewModel : ViewModel(), ItemClickListener {

    private val auth by lazy { FirebaseAuth.getInstance() }
    private val firestore by lazy { FirebaseFirestore.getInstance() }
    private lateinit var callback : ProfileClickListener
    val user = MutableLiveData<User>()
    val adapter = FavoriteAdapter(this)

    fun bindCallback(callback : ProfileClickListener){
        this.callback = callback

        adapter.submitList(
            listOf(
                FavoriteModel(1, "Favorite Marvel Characters"),
                FavoriteModel(2, "Favorite Marvel Stories"),
                FavoriteModel(3, "Favorite Marvel Events"),
                FavoriteModel(4, "Favorite Marvel Comics"),
                FavoriteModel(5, "Favorite Marvel Series")
            )
        )
    }

    fun getUserData() {
        val userId = auth.currentUser?.uid

        val documentReference = firestore.collection("users").document(userId.toString())
        documentReference.addSnapshotListener { p0, p1 ->
            val userModel = p0?.toObject(User::class.java)
            userModel?.let{ user.value = it }
        }
    }

    override fun onItemClick(view: View) {
        when(view.tag){
            is FavoriteModel -> callback.onFavoriteCategoryClick(view.tag as FavoriteModel)
        }
    }
}
