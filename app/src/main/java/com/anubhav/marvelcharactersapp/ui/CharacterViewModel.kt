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

class CharacterViewModel(
    val marvelRepository: MarvelRepository
) : ViewModel() {

    val characters: MutableLiveData<Resource<CharacterResponse>> = MutableLiveData()

    var characterResponse : CharacterResponse?= null

    private fun getCharacters(offset: String) = viewModelScope.launch {
        characters.postValue(Resource.Loading())
        val response = marvelRepository.getAllCharacters(20)
        characters.postValue(handleCharacterResponse(response))
    }
    init {
        getCharacters("30")
    }

    private fun handleCharacterResponse(response:Response<CharacterResponse>): Resource<CharacterResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
//
//                if (characterResponse == null) {
//                    characterResponse = resultResponse
//                }
//                else{
//                    val oldCharacters = characterResponse!!.data.results.map {
//                        it.toCharacterModel()
//                    } as MutableList<CharacterModel>
//                    val newCharacters = resultResponse.data.results.map {
//                        it.toCharacterModel()
//                    } as MutableList<CharacterModel>
//                    oldCharacters.addAll(newCharacters)
//                }
            }
            }
        return Resource.Error(response.message())
    }

}