package com.stathis.marvelmania.ui.home

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : MarvelFragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun startOperations() {
        viewModel.getResultsFromApi()

        home_comic_recycler.adapter = viewModel.adapter

        observeData()
    }

    override fun stopOperations() {
        removeObservers()
    }

    private fun observeData() {
        viewModel.data.observe(this, Observer {
            Log.d("",it.toString())
            it?.let {
                home_popular_header.text = it.results.first().name
                home_comic_header.text = getString(R.string.popular_comics_home, it.results.first().name)
                val imagePath = "${it.results.first().thumbnail.path}/portrait_incredible.${it.results.first().thumbnail.extension}"
                Glide.with(this).load(imagePath).into(home_popular_img)
            }
        })

        viewModel.observeData(this)
    }

    private fun removeObservers(){
        viewModel.data.removeObservers(this)
        viewModel.comics.removeObservers(this)
    }

    private fun goToDetails() {
        Navigation.findNavController(requireView()).navigate(R.id.action_details)
    }
}