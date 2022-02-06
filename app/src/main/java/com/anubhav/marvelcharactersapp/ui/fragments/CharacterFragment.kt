package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.anubhav.marvelcharactersapp.MarvelViewModelFactory
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.adapters.CharacterAdapter
import com.anubhav.marvelcharactersapp.data.dto.Result
import com.anubhav.marvelcharactersapp.databinding.FragmentCharacterBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding
import com.anubhav.marvelcharactersapp.domain.models.CharacterModel
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import com.anubhav.marvelcharactersapp.ui.CharacterViewModel
import com.anubhav.marvelcharactersapp.ui.MainActivity
import com.anubhav.marvelcharactersapp.util.Resource
import kotlinx.android.synthetic.main.fragment_character.*


class CharacterFragment : Fragment(R.layout.fragment_character) {
    private val TAG = "CharacterFragment"
    lateinit var viewModel: CharacterViewModel
    lateinit var characterAdapter: CharacterAdapter

    private var _binding : FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val marvelRepository = MarvelRepository()
        val viewModelProvider = MarvelViewModelFactory(marvelRepository)
        viewModel = ViewModelProvider(this,viewModelProvider).get(CharacterViewModel::class.java)
        _binding = FragmentCharacterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
            viewModel.characters.observe(viewLifecycleOwner, Observer { response ->
                when(response) {
                    is Resource.Success -> {
                        response.data?.let { characterResponse ->
                            characterAdapter.differ.submitList(characterResponse.data.results.toList().map {
                                it.toCharacterModel()
                            })
                        }
                    }
                    is Resource.Error -> {

                        response.message?.let { message ->
                            Log.e(TAG, "An error occurred: $message")
                        }
                    }
                    is Resource.Loading->{
                        response.data?.let { characterResponse ->
                            characterAdapter.differ.submitList(characterResponse.data.results.toList().map {
                                it.toCharacterModel()
                            })
                        }

                    }
                }
            })
    }

    private fun setupRecyclerView(){
        characterAdapter = CharacterAdapter()
        rvChar.apply{
            adapter = characterAdapter
            layoutManager = GridLayoutManager(activity,3)
        }
    }

}

