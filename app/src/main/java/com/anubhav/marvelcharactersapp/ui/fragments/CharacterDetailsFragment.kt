package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.databinding.FragmentCharacterBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentCharacterDetailsBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding


class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {
    private val TAG = "CharacterDetailsFragment"
    private var _binding : FragmentCharacterDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

        }
    }


}