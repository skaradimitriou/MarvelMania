package com.stathis.marvelmania.features.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.stathis.marvelmania.util.TAG

class RegisterViewModel : ViewModel() {

    val auth by lazy { FirebaseAuth.getInstance() }
    val firestore by lazy { FirebaseFirestore.getInstance() }
    val userCreated = MutableLiveData<Boolean>()
    val passwordsMatch = MutableLiveData<Boolean>()

    fun validateUserInput(email: String, pass: String, passConf: String) {
        when (pass.equals(passConf)) {
            true -> registerUserToFirebase(email, pass)
            false -> passwordsMatch.value = false
        }
    }

    private fun registerUserToFirebase(email: String, pass: String) {
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            when (it.isSuccessful) {
                true -> createUserInFirestore(email)
                false -> userCreated.value = false
            }
        }
    }

    private fun createUserInFirestore(email : String) {
        val documentReference = firestore.collection("users").document(auth.currentUser!!.uid)

        val data: HashMap<String, Any> = hashMapOf(
            "username" to email.takeWhile { it != '@' },
            "favoritesHeroes" to emptyMap<String,String>(),
            "favoritesStories" to emptyMap<String,String>(),
            "userImg" to "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
            "email" to email
        )

        documentReference.set(data).addOnSuccessListener {
            Log.d(TAG, "User profile is created for Stathis")
            userCreated.value = true
        }

        documentReference.set(data).addOnFailureListener {
            Log.d(TAG, "User profile is created for Stathis")
            userCreated.value = false
        }
    }
}
