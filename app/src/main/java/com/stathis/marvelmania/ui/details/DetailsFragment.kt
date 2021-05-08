package com.stathis.marvelmania.ui.details

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.models.characters.MarvelCharacter
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : MarvelFragment(R.layout.fragment_details) {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var character: MarvelCharacter

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun startOperations() {
        arguments?.let {
            character = DetailsFragmentArgs.fromBundle(it).character

            viewModel.charactedId = character.id

            viewModel.getCharacterData()
        }

        viewModel.comics.observe(this, Observer {
            Log.d("",it.toString())
            comics_fragment_header.text = "COMICS : ${it?.results?.size}"
        })

        viewModel.events.observe(this, Observer {
            Log.d("",it.toString())
            events_fragment_header.text = "EVENTS : ${it?.results?.size}"
        })

        viewModel.series.observe(this, Observer {
            Log.d("",it.toString())
            series_fragment_header.text = "SERIES : ${it?.results?.size}"
        })

        viewModel.stories.observe(this, Observer {
            Log.d("",it.toString())
            stories_fragment_header.text = "STORIES : ${it?.results?.size}"
        })
    }

    override fun stopOperations() {
        viewModel.removeObservers(this)
    }
}