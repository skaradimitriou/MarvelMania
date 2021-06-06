package com.stathis.marvelmania.callbacks

import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.comics.Comic
import com.stathis.marvelmania.models.events.Event
import com.stathis.marvelmania.models.stories.Story

interface HomeClickListener {

    fun onComicClick(comic : Comic)
    fun onHeroClick(hero : MarvelCharacter)
    fun onEventClick(event : Event)
}
