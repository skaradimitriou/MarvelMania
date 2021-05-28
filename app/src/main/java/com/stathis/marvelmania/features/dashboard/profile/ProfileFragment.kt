package com.stathis.marvelmania.features.dashboard.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment

class ProfileFragment : MarvelFragment(R.layout.fragment_profile) {

    private lateinit var viewModel: ProfileViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun startOperations() {}

    override fun stopOperations() {}
}