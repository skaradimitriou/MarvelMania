package com.stathis.marvelmania.util

import com.stathis.marvelmania.models.PopularMarvelHero

object MarvelHeroGenerator {

    private var popularHeroList: List<PopularMarvelHero> = listOf(
        PopularMarvelHero("Iron Man", 1009368),
        PopularMarvelHero("Spider-Man", 1009610),
        PopularMarvelHero("Deadpool", 1009268),
        PopularMarvelHero("Captain America", 1009220),
        PopularMarvelHero("Wolverine", 1009718),
        PopularMarvelHero("Hulk", 1009351),
        PopularMarvelHero("Hawkeye", 1009338),
        PopularMarvelHero("Thor", 1009664),
        PopularMarvelHero("Thanos", 1009652)
    )

    fun getPopularHeroList(): List<PopularMarvelHero> {
        return popularHeroList
    }

    fun getRandomHero(): Int {
        val randomNumber = popularHeroList.indices.random()
        return popularHeroList.get(randomNumber).id
    }
}