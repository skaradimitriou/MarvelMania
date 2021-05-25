package com.stathis.marvelmania.features.details

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import com.stathis.marvelmania.models.characters.MarvelCharacter
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : MarvelActivity(R.layout.activity_details) {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var character: MarvelCharacter

    override fun initLayout() {
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun startOperations() {
        val characterData = intent.getStringExtra("CHARACTER")
        character = Gson().fromJson(characterData, MarvelCharacter::class.java)

        Log.d("CHARACTER DATA",character.toString())

        character?.let {
            viewModel.charactedId = character.id

            viewModel.bindCharacterData(character)
        }

        details_screen_recycler.adapter = viewModel.adapter
    }

    override fun stopOperations() {
        viewModel.removeObservers(this)
    }
}