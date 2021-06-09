package com.stathis.marvelmania.models

data class User(
    val username: String,
    val email: String,
    val userImg: String,
    val favoriteHeroes: HashMap<String, Any> = hashMapOf(),
    val favoriteStories: HashMap<String, Any> = hashMapOf()
) {
    constructor() : this(
        "", "", "", hashMapOf<String, Any>(), hashMapOf<String, Any>()
    )
}