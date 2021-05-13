package com.stathis.marvelmania.ui.comicDetails

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.models.comics.Comic
import kotlinx.android.synthetic.main.fragment_comic_results.*

class ComicResultsFragment : MarvelFragment(R.layout.fragment_comic_results) {

    private lateinit var viewModel: ComicResultsViewModel
    private lateinit var comic: Comic

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(ComicResultsViewModel::class.java)
    }

    override fun startOperations() {
        arguments?.let {
            comic = ComicResultsFragmentArgs.fromBundle(it).comic

            Log.d("", comic.toString())
            val imagePath = "${comic.thumbnail.path}/portrait_medium.${comic.thumbnail.extension}"
            Glide.with(this).load(imagePath).into(comic_img)
            comic_title.text = comic.title

            when (comic.description.isNullOrEmpty()) {
                true -> comic_description.text = getString(R.string.comic_empty_description)
                false -> comic_description.text = comic.description
            }
        }

    }

    override fun stopOperations() {
        //handle this once its done
    }
}