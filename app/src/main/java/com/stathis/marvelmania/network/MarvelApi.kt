package com.stathis.marvelmania.network

import com.stathis.marvelmania.models.MainResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    /*
     *  Characters Api Endpoints bellow
     */

    @GET("v1/public/comics")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    @GET("v1/public/comics/{characterId}")
    suspend fun getCharacterById(
        @Query("characterId") id: String,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>


    /*
     *  Comics Api Endpoints bellow
     */

    @GET("v1/public/comics")
    suspend fun getComics(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    @GET("v1/public/comics/{comicId}/characters")
    suspend fun getCharactersFromComicId(
        @Path("comicId") comidId : Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    /*
     *  Creators Api Endpoints bellow
     */

    @GET("v1/public/creators")
    suspend fun getCreators(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    /*
     *  Events Api Endpoints bellow
     */

    @GET("v1/public/events")
    suspend fun getEvents(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    /*
    *  Series Api Endpoints bellow
    */

    @GET("v1/public/series")
    suspend fun getSeries(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    /*
    *  Stories Api Endpoints bellow
    */

    @GET("v1/public/stories")
    suspend fun getStories(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>
}