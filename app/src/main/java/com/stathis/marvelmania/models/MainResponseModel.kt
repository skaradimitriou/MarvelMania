package com.stathis.marvelmania.models

class MainResponseModel(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: ResponseModel
) : MarvelModel