package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.anubhav.marvelcharactersapp.MarvelViewModelFactory
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import com.anubhav.marvelcharactersapp.ui.CharacterViewModel
import com.anubhav.marvelcharactersapp.ui.MainActivity
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel: CharacterViewModel

    private val TAG = "HomeFragment"
    private var _binding : FragmentHomeBinding ? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        viewModel = (activity as MainActivity).viewModel
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding){

        cvChar.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_characterFragment)

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