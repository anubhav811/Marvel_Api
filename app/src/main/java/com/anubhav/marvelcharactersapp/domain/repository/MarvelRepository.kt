package com.anubhav.marvelcharactersapp.domain.repository

import com.anubhav.marvelcharactersapp.data.MarvelApi
import com.anubhav.marvelcharactersapp.data.RetrofitInstance
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse

class MarvelRepository (
    private val Api: MarvelApi? = RetrofitInstance.api
        ){
    suspend fun getAllCharacters(offset:Int): CharacterResponse? =
        Api?.getAllCharacters(offset = 20.toString())
}