package com.stathis.marvelmania.network

import com.stathis.marvelmania.models.characters.MainResponseModel
import com.stathis.marvelmania.models.comics.ComicDataWrapper
import com.stathis.marvelmania.models.events.EventDataWrapper
import com.stathis.marvelmania.models.series.SeriesDataWrapper
import com.stathis.marvelmania.models.stories.StoryDataContainer
import com.stathis.marvelmania.models.stories.StoryDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    /*
     *  Characters Api Endpoints bellow
     */

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    @GET("v1/public/characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") id: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<MainResponseModel>

    @GET("v1/public/characters/{characterId}/comics")
    suspend fun getCharacterComics(
        @Path("characterId") id: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<ComicDataWrapper>

    @GET("v1/public/characters/{characterId}/events")
    suspend fun getCharacterEvents(
        @Path("characterId") id: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<EventDataWrapper>

    @GET("v1/public/characters/{characterId}/series")
    suspend fun getCharacterSeries(
        @Path("characterId") id: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<SeriesDataWrapper>

    @GET("v1/public/characters/{characterId}/stories")
    suspend fun getCharacterStories(
        @Path("characterId") id: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<StoryDataWrapper>

    /*
     *  Comics Api Endpoints bellow
     */

    @GET("v1/public/comics")
    suspend fun getComics(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Response<ComicDataWrapper>

    @GET("v1/public/comics/{comicId}/characters")
    suspend fun getCharactersFromComicId(
        @Path("comicId") comidId: Int,
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