package com.stathis.marvelmania.features.comics

import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.adapters.ComicAdapter
import kotlinx.android.synthetic.main.custom_marvel_toolbar.*
import kotlinx.android.synthetic.main.fragment_comics.*
import kotlinx.android.synthetic.main.fragment_home.marvel_toolbar

class ComicsFragment : MarvelFragment(R.layout.fragment_comics) {

    private lateinit var viewModel: ComicViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(ComicViewModel::class.java)
    }

    override fun startOperations() {
        viewModel.getComics()
        viewModel.comics.observe(this, Observer {
            Log.d("", it.toString())
            val adapter = ComicAdapter()
            hero_viewpager.adapter = adapter
            adapter.submitList(it.results)
            comic_counter.text = "COMICS: ${it.results.size}"
        })
    }

    override fun stopOperations() {
        viewModel.comics.removeObservers(this)
    }
}