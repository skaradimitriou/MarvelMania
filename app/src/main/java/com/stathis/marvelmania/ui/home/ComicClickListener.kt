package com.stathis.marvelmania.ui.home

import com.stathis.marvelmania.models.comics.Comic

interface ComicClickListener {

    fun onComicClick(comic : Comic)
}
