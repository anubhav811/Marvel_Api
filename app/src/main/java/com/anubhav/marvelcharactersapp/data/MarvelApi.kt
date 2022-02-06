package com.anubhav.marvelcharactersapp.data

import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse
import com.anubhav.marvelcharactersapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(

        @Query("apikey")
        apikey:String = Constants.API_KEY,
        @Query("ts")
        ts:String = Constants.timeStamp,
        @Query("hash")
        hash:String = Constants.hash()
    ): Response<CharacterResponse>

}