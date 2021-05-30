package com.stathis.marvelmania.features.dashboard.home

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.callbacks.ComicClickListener
import com.stathis.marvelmania.features.comicDetails.ComicDetailsActivity
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.comics.Comic
import com.stathis.marvelmania.features.details.DetailsActivity
import com.stathis.marvelmania.util.getIncrediblePhoto
import kotlinx.android.synthetic.main.custom_marvel_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : MarvelFragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel
    private lateinit var character: MarvelCharacter

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun startOperations() {
        viewModel.getResultsFromApi()

        home_comic_recycler.adapter = viewModel.adapter

        learn_more_btn.setOnClickListener {
            goToDetails(character)
        }

        observeData()
    }

    override fun stopOperations() {
        removeObservers()
    }

    private fun observeData() {
        viewModel.data.observe(this, Observer {
            Log.d("", it.toString())
            it?.let {
                character = it.results.first()
                home_popular_header.text = it.results.first().name
                home_comic_header.text = getString(R.string.popular_comics_home, it.results.first().name)

                val imagePath = getIncrediblePhoto(it.results.first().thumbnail.path,it.results.first().thumbnail.extension)
                Glide.with(this).load(imagePath).into(home_popular_img)
            }
        })

        viewModel.observeData(this,object : ComicClickListener {
            override fun onComicClick(comic: Comic) {
                //logic -> go to ComicDetails
                val comicData = Gson().toJson(character)
                startActivity(Intent(requireContext(), ComicDetailsActivity::class.java).putExtra("COMIC", comicData))
            }
        })
    }

    private fun removeObservers() {
        viewModel.data.removeObservers(this)
        viewModel.comics.removeObservers(this)
    }

    private fun goToDetails(character: MarvelCharacter) {
        val characterJson = Gson().toJson(character)
        startActivity(Intent(requireContext(), DetailsActivity::class.java).putExtra("CHARACTER", characterJson))
    }
}