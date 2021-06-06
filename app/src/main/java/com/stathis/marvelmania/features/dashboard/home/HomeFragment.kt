package com.stathis.marvelmania.features.dashboard.home

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.callbacks.HomeClickListener
import com.stathis.marvelmania.features.comicDetails.ComicDetailsActivity
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.comics.Comic
import com.stathis.marvelmania.features.details.DetailsActivity
import com.stathis.marvelmania.models.events.Event
import com.stathis.marvelmania.models.stories.Story
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
        home_heroes_recycler.adapter = viewModel.heroAdapter
        home_events_recycler.adapter = viewModel.eventsAdapter

        observeData()
    }

    override fun stopOperations() {
        removeObservers()
    }

    private fun observeData() {
        viewModel.heroes.observe(this, Observer {
            Log.d("", it.toString())
            it?.let {
                character = it.results.first()
            }
        })

        viewModel.observeData(this,object : HomeClickListener {
            override fun onComicClick(comic: Comic) = goToComicDetails(comic)
            override fun onHeroClick(hero: MarvelCharacter) = goToDetails(hero)
            override fun onEventClick(event: Event) = goToEvents(event)
        })
    }

    private fun removeObservers() {
        viewModel.heroes.removeObservers(this)
        viewModel.comics.removeObservers(this)
    }

    private fun goToDetails(character: MarvelCharacter) {
        val characterJson = Gson().toJson(character)
        startActivity(Intent(requireContext(), DetailsActivity::class.java).putExtra("CHARACTER", characterJson))
    }

    private fun goToComicDetails(comic : Comic){
        val comicData = Gson().toJson(comic)
        startActivity(Intent(requireContext(), ComicDetailsActivity::class.java).putExtra("COMIC", comicData))
    }

    private fun goToEvents(event: Event) {
        Toast.makeText(requireContext(), event.title, Toast.LENGTH_LONG).show()
    }
}