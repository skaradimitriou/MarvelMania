package com.stathis.marvelmania.models.comics

import com.stathis.marvelmania.models.MarvelModel
import com.stathis.marvelmania.models.characters.ImageModel
import com.stathis.marvelmania.models.characters.MarvelCharacter
import java.util.*

class Comic (
    val id : Int,
    val digitalId : Int,
    val title : String,
    val description : String,
    val modified : String,
    val format : String,
    val pageCount : Int,
    val thumbnail: ImageModel
): MarvelModel