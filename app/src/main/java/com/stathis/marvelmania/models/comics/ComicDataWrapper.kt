package com.stathis.marvelmania.models.comics

import com.stathis.marvelmania.models.MarvelModel

class ComicDataWrapper (
    val code : Int,
    val status : String,
    val copyright : String,
    val data : ComicDataContainer
) : MarvelModel