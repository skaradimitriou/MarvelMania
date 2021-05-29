package com.stathis.marvelmania.features.dashboard.search

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.callbacks.CharacterClickListener
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.features.details.DetailsActivity
import com.stathis.marvelmania.util.TAG
import kotlinx.android.synthetic.main.custom_marvel_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.marvel_toolbar
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : MarvelFragment(R.layout.fragment_search) {

    private lateinit var viewModel: SearchViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun startOperations() {
        search_results.adapter = viewModel.adapter

        search_searchbar.setOnClickListener {
            search_searchbar.isIconified = false
        }

        search_searchbar.clearFocus()
        search_searchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search_searchbar.clearFocus()
                search_searchbar.setQuery("", false)
                Log.d(TAG, query)
                query?.let { viewModel.getResultsForCharacter(query) }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        viewModel.data.observe(this, Observer {
            //hide progressbar
        })

        viewModel.observeData(this, object : CharacterClickListener {
            override fun onCharacterClick(character: MarvelCharacter) {
                goToDetails(character)
            }
        })
    }

    override fun stopOperations() {
        viewModel.data.removeObservers(this)
    }

    private fun goToDetails(character: MarvelCharacter) {
        val characterJson = Gson().toJson(character)
        startActivity(Intent(requireContext(), DetailsActivity::class.java).putExtra("CHARACTER", characterJson))
    }
}