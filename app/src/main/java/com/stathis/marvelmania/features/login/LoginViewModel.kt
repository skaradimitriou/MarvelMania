package com.stathis.marvelmania.features.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel(){

    val auth by lazy { FirebaseAuth.getInstance() }
    val userAuthenticated = MutableLiveData<Boolean>()

    fun validateUser(email : String, pass : String) {
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            when(it.isSuccessful){
                true -> userAuthenticated.value = true
                false -> userAuthenticated.value = false
            }
        }
    }
}
