package com.anubhav.marvelcharactersapp.data.repository
import com.anubhav.marvelcharactersapp.data.MarvelApi
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepoImp @Inject constructor(
    private val api:MarvelApi
): MarvelRepository{
    override suspend fun getAllCharacters(offset: Int): CharacterResponse {
        return api.getAllCharacters(offset=offset.toString())
    }
}