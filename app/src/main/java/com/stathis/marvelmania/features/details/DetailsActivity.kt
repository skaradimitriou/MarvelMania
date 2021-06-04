package com.stathis.marvelmania.features.details

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import com.stathis.marvelmania.callbacks.DetailsClickListener
import com.stathis.marvelmania.models.characters.MarvelCharacter
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : MarvelActivity(R.layout.activity_details),DetailsClickListener {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var character: MarvelCharacter

    override fun initLayout() {
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun startOperations() {
        viewModel.initListener(this)

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

    override fun onBackBtnClick() {
        onBackPressed()
    }

    override fun onShareBtnClick() {
        startActivity(Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT,
                "I think that you might be interested in ${character.description}. Check it out here!"
            )
        })
    }
}