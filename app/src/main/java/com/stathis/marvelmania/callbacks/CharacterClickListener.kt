package com.stathis.marvelmania.callbacks

import com.stathis.marvelmania.models.characters.MarvelCharacter

interface CharacterClickListener {

    fun onCharacterClick(character : MarvelCharacter)
}