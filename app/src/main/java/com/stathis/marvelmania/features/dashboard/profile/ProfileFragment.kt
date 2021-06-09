package com.stathis.marvelmania.features.dashboard.profile

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.models.FavoriteModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : MarvelFragment(R.layout.fragment_profile) {

    private lateinit var viewModel: ProfileViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun startOperations() {
        viewModel.getUserData()

        favorites_recycler.adapter = viewModel.adapter

        viewModel.bindCallback(object : ProfileClickListener{
            override fun onFavoriteCategoryClick(fav: FavoriteModel) {
                when(fav.id){
                    1 -> {  }
                    2 -> {  }
                    3 -> {  }
                    4 -> {  }
                    5 -> {  }
                }
            }
        })

        profile_image.setOnClickListener {
           /*
           upload photo from camera & gallery
            */
        }

        viewModel.user.observe(this, Observer {
            it?.let{
                Glide.with(this).load(it.userImg).into(profile_image)
                profile_username.text = it.username
                profile_email.text = it.email
            }
        })
    }

    override fun stopOperations() {
        viewModel.user.removeObservers(this)
    }
}