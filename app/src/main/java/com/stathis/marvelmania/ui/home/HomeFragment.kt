package com.stathis.marvelmania.ui.home

import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.models.characters.MarvelCharacter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : MarvelFragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel
    private lateinit var character : MarvelCharacter

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun startOperations() {
        viewModel.getResultsFromApi()

        home_comic_recycler.adapter = viewModel.adapter

        home_menu_icon.setOnClickListener {
            //this should toggle the menu
            val drawer = activity?.findViewById(R.id.drawer_layout) as DrawerLayout
            drawer.openDrawer(GravityCompat.START)
        }

        home_search_icon.setOnClickListener {
            goToSearch()
        }

        learn_more_btn.setOnClickListener{
            goToDetails(character)
        }

        observeData()
    }

    override fun stopOperations() {
        removeObservers()
    }

    private fun observeData() {
        viewModel.data.observe(this, Observer {
            Log.d("",it.toString())
            it?.let {
                character = it.results.first()
                home_popular_header.text = it.results.first().name
                home_comic_header.text = getString(R.string.popular_comics_home, it.results.first().name)
                val imagePath = "${it.results.first().thumbnail.path}/portrait_incredible.${it.results.first().thumbnail.extension}"
                //Glide.with(this).load(imagePath).into(home_popular_img)
            }
        })

        viewModel.observeData(this)
    }

    private fun removeObservers(){
        viewModel.data.removeObservers(this)
        viewModel.comics.removeObservers(this)
    }

    private fun goToSearch() {
        Navigation.findNavController(requireView()).navigate(R.id.action_search)
    }

    private fun goToDetails(character : MarvelCharacter) {
        val test = HomeFragmentDirections.actionDetails(character)
        Navigation.findNavController(requireView()).navigate(test)
    }
}