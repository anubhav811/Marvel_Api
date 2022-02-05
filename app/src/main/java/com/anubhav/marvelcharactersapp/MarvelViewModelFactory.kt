package com.anubhav.marvelcharactersapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import com.anubhav.marvelcharactersapp.ui.CharacterViewModel

class MarvelViewModelFactory(
    val characterRepository: MarvelRepository
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharacterViewModel(characterRepository) as T
    }
}