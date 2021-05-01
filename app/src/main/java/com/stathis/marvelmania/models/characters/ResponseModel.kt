package com.stathis.marvelmania.models.characters

import com.stathis.marvelmania.models.MarvelModel

class ResponseModel(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<MarvelCharacter>
) : MarvelModel