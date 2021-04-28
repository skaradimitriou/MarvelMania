package com.stathis.marvelmania.models

class ResponseModel(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<MarvelCharacter>
) : MarvelModel