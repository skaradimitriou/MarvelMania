package com.stathis.marvelmania.util

import java.math.BigInteger
import java.security.MessageDigest

val TAG = "MARVEL APP"
val BASE_URL = "https://gateway.marvel.com/"
val TS = "6"
val API_KEY = "62603ee7f9eb24e366fb466a32fe04ec"
val PRIVATE_KEY = "1d409a43d3561f50060e16e375a87500142efff2"

val GENERATE_HASH = TS + PRIVATE_KEY + API_KEY
val FINAL_HASH_KEY = generateMd5HashKey(GENERATE_HASH)

fun generateMd5HashKey(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}