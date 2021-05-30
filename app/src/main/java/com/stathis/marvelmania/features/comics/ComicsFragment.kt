package com.stathis.marvelmania.features.comics

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.adapters.ComicAdapter
import kotlinx.android.synthetic.main.fragment_comics.*

class ComicsFragment : MarvelFragment(R.layout.fragment_comics) {

    private lateinit var viewModel: ComicViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(ComicViewModel::class.java)
    }

    override fun startOperations() {
        viewModel.getComics()
        viewModel.comics.observe(this, Observer {
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