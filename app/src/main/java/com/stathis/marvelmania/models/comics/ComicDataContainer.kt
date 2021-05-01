package com.stathis.marvelmania.models.comics

import com.stathis.marvelmania.models.MarvelModel

class ComicDataContainer(
    val offset : Int,
    val limit : Int,
    val total : Int,
    val count : Int,
    val results : List<Comic>
): MarvelModel