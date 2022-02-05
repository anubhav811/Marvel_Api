package com.anubhav.marvelcharactersapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import com.anubhav.marvelcharactersapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class CharacterViewModel(
    val marvelRepository: MarvelRepository
) : ViewModel() {
    val characters: MutableLiveData<Resource<CharacterResponse>> = MutableLiveData()

    var characterResponse : CharacterResponse?= null

    fun getCharacters(offset: String) = viewModelScope.launch {
            characters.postValue(Resource.Loading())
        val response = marvelRepository.getAllCharacters(20)
        characters.postValue(handleCharacterResponse(response))
    }

    private fun handleCharacterResponse(response: Response<CharacterResponse>): Resource<CharacterResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                if (characterResponse == null) {
                    characterResponse = resultResponse
                }
                return Resource.Success(characterResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}