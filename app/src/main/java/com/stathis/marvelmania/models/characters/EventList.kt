package com.stathis.marvelmania.models.characters

class EventList(
    val available : Int,
    val collectionUri : String,
    val items : List<MarvelEvent>,
    val returned : Int
)