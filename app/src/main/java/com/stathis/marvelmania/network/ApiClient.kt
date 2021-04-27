package com.stathis.marvelmania.network

import com.stathis.marvelmania.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService(): MarvelApi {
        val service = retrofit.create(MarvelApi::class.java)
        return service
    }
}