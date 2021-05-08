package com.stathis.marvelmania.ui.comicDetails

import android.view.View
import com.bumptech.glide.Glide
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.comics.Comic
import com.stathis.marvelmania.ui.comicDetails.ComicResultsFragmentArgs.fromBundle
import com.stathis.marvelmania.ui.details.DetailsFragmentArgs
import com.stathis.marvelmania.ui.details.DetailsFragmentArgs.fromBundle
import kotlinx.android.synthetic.main.fragment_comic_results.*

class ComicResultsFragment : MarvelFragment(R.layout.fragment_comic_results) {

    private lateinit var comic: Comic

    override fun initLayout(view: View) {
        //
    }

    override fun startOperations() {
        arguments?.let {
            comic = ComicResultsFragmentArgs.fromBundle(it).comic

            val imagePath = "${comic.thumbnail.path}/portrait_medium.${comic.thumbnail.extension}"
            Glide.with(this).load(imagePath).into(comic_results_img)
        }

    }

    override fun stopOperations() {
        //
    }
}