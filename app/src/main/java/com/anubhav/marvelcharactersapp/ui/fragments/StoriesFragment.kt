package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentSeriesBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentStoriesBinding


class StoriesFragment : Fragment(R.layout.fragment_stories) {
    private val TAG = "StoriesFragment"
    private var _binding : FragmentStoriesBinding ? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

        }
    }

}