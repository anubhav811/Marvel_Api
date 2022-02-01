package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.databinding.FragmentComicsBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentCreatorsBinding
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding


class CreatorsFragment : Fragment(R.layout.fragment_creators) {
    private val TAG = "CreatorsFragment"
    private var _binding : FragmentCreatorsBinding ? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreatorsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
        }
    }

}