package com.anubhav.marvelcharactersapp.domain.repository

import com.anubhav.marvelcharactersapp.data.RetrofitInstance
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse

interface MarvelRepository {
    suspend fun getAllCharacters(offset:Int):CharacterResponse =
        RetrofitInstance.api.getAllCharacters(offset = 20.toString())
}