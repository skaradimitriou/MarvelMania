package com.stathis.marvelmania.models.characters

class ComicList(
    val available : Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items : List<MarvelComic>
)