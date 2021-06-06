package com.stathis.marvelmania.features.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel : ViewModel() {

    val auth by lazy { FirebaseAuth.getInstance() }
    val userCreated = MutableLiveData<Boolean>()
    val passwordsMatch = MutableLiveData<Boolean>()

    fun validateUserInput(email : String, pass : String, passConf : String) {
        when(pass.equals(passConf)){
            true -> registerUserToFirebase(email, pass)
            false -> passwordsMatch.value = false
        }
    }

    private fun registerUserToFirebase(email : String, pass : String){
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            when(it.isSuccessful){
                true -> userCreated.value = true
                false -> userCreated.value = false
            }
        }
    }
}
