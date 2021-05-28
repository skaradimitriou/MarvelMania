package com.stathis.marvelmania.features.login

import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity

class LoginActivity : MarvelActivity(R.layout.activity_login) {

    private lateinit var viewModel : LoginViewModel

    override fun initLayout() {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun startOperations() {
        //
    }

    override fun stopOperations() {}
}