package com.anubhav.marvelcharactersapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse
import com.anubhav.marvelcharactersapp.domain.models.CharacterModel
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import com.anubhav.marvelcharactersapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MarvelViewModel(
    val marvelRepository: MarvelRepository
) : ViewModel() {

    val characters: MutableLiveData<Resource<CharacterResponse>> = MutableLiveData()
    var characterPage = 0

    var characterResponse : CharacterResponse?= null

    fun getCharacters(offset:Int) = viewModelScope.launch {
        characters.postValue(Resource.Loading())
        val response = marvelRepository.getAllCharacters(offset)
        characters.postValue(handleCharacterResponse(response))
    }
    init {
        getCharacters(offset = 0)
    }

    private fun handleCharacterResponse(response:Response<CharacterResponse>): Resource<CharacterResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                characterPage++
                if (characterResponse == null) {
                    characterResponse = resultResponse
                }
                else{
                    val oldCharacters = characterResponse!!.data.results.map {
                        it.toCharacterModel()
                    } as MutableList<CharacterModel>
                    val newCharacters = resultResponse.data.results.map {
                        it.toCharacterModel()
                    } as MutableList<CharacterModel>
                    oldCharacters.addAll(newCharacters)
                }
                return Resource.Success(characterResponse?:resultResponse)

            }
            }
        return Resource.Error(response.message())
    }

}