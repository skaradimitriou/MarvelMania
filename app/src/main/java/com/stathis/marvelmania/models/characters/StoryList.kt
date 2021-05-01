package com.stathis.marvelmania.models.characters

class StoryList(
    val available : Int,
    val collectionUri : String,
    val items : List<MarvelStory>,
    val returned : Int
)