package com.stathis.marvelmania.features.register

import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity

class RegisterActivity : MarvelActivity(R.layout.activity_register) {

    private lateinit var viewModel: RegisterViewModel

    override fun initLayout() {
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun startOperations() {

    }

    override fun stopOperations() {

    }
}