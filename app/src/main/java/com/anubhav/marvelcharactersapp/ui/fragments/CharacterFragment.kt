package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.adapters.CharacterAdapter
import com.anubhav.marvelcharactersapp.databinding.FragmentCharacterBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding
import com.anubhav.marvelcharactersapp.ui.CharacterViewModel
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
        setupRecyclerView()
        _binding = FragmentCharacterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            viewModel.characters.observe(viewLifecycleOwner, Observer { response ->
                when(response) {
                    is Resource.Success -> {
                        response.data?.let { characterResponse ->
                            characterAdapter.differ.submitList(characterResponse.data.results.toList())
                        }
                    }
                    is Resource.Error -> {
                        response.message?.let { message ->
                            Log.e(TAG, "An error occured: $message")
                        }
                    }
                }
            })
        }
    }

    private fun setupRecyclerView(){
        characterAdapter = CharacterAdapter()
        rvChar.apply{
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}