package com.anubhav.marvelcharactersapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anubhav.marvelcharactersapp.data.dto.CharacterResponse
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import com.anubhav.marvelcharactersapp.util.Resource
import kotlinx.coroutines.launch

class MarvelViewModel(
    val marvelRepository : MarvelRepository
) :ViewModel(){
}

