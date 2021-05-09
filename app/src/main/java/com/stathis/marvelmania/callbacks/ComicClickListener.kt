package com.stathis.marvelmania.callbacks

import com.stathis.marvelmania.models.comics.Comic

interface ComicClickListener {

    fun onComicClick(comic : Comic)
}
