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

            Log.d("",character.toString())
            viewModel.charactedId = character.id

            viewModel.bindCharacterData(character)
        }

        details_screen_recycler.adapter = viewModel.adapter
    }

    override fun stopOperations() {
        viewModel.removeObservers(this)
    }
}