package com.stathis.marvelmania.models.characters

import com.stathis.marvelmania.models.MarvelModel

class MainResponseModel(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: ResponseModel
) : MarvelModel