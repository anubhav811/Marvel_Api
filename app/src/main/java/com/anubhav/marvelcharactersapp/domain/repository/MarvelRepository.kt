package com.anubhav.marvelcharactersapp.domain.repository

import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse

interface MarvelRepository {

    suspend fun getAllCharacters(offset:Int):CharacterResponse
}