package com.anubhav.marvelcharactersapp.domain.repository

import com.anubhav.marvelcharactersapp.data.MarvelApi
import com.anubhav.marvelcharactersapp.data.RetrofitInstance
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse
import retrofit2.Response

class MarvelRepository (
    private val Api: MarvelApi = RetrofitInstance.api
        ){
    suspend fun getAllCharacters(): Response<CharacterResponse> {
        return Api.getAllCharacters()
}
}