package com.stathis.marvelmania.network

import com.stathis.marvelmania.models.MainResponseModel
import com.stathis.marvelmania.models.ResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("v1/public/comics")
   suspend fun getSuperheroes(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>
}