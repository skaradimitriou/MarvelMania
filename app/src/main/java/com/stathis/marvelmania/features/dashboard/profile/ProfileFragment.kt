package com.stathis.marvelmania.features.dashboard.profile

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : MarvelFragment(R.layout.fragment_profile) {

    private lateinit var viewModel: ProfileViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun startOperations() {
        val url = "https://eleftherostypos.gr/wp-content/uploads/2017/11/thor-ragnarok-marvel.png"
        Glide.with(this).load(url).into(profile_image)
    }

    override fun stopOperations() {}
}