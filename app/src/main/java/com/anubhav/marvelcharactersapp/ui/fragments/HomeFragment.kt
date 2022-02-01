package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val TAG = "HomeFragment"
    private var _binding : FragmentHomeBinding ? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
           cvChar.setOnClickListener{
               fragmentManager?.beginTransaction()?.replace(R.id.navHostFragment,CharacterFragment())
                   ?.commit()
           }

           cvComics.setOnClickListener{


           }

           cvEvents.setOnClickListener{

           }

           cvStories.setOnClickListener{

           }

           cvSeries.setOnClickListener{

           }

           cvCreators.setOnClickListener{

           }
        }
    }

}