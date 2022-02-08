package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding
import com.anubhav.marvelcharactersapp.ui.MarvelViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel: MarvelViewModel

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

        ivChar.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_characterFragment)

        }

            ivComics.setOnClickListener{


           }

           ivEvents.setOnClickListener{

           }

           ivStories.setOnClickListener{

           }

           ivSeries.setOnClickListener{

           }

           ivCreators.setOnClickListener{

           }
        }
    }

}