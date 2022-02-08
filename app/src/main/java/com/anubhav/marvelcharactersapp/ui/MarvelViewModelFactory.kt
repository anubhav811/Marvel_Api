package com.anubhav.marvelcharactersapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository

class MarvelViewModelFactory(
    val characterRepository: MarvelRepository
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MarvelViewModel(characterRepository) as T
    }
}