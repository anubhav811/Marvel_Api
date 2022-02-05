package com.anubhav.marvelcharactersapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.anubhav.marvelcharactersapp.MarvelViewModelFactory
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     lateinit var navController:NavController
//     lateinit var viewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val marvelRepository = MarvelRepository()
//        val viewModelProvider = MarvelViewModelFactory(marvelRepository)
//        viewModel = ViewModelProvider(this,viewModelProvider).get(CharacterViewModel::class.java)

        navController  = navHostFragment.getFragment<NavHostFragment>().navController

    }

}