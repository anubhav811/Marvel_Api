package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    private  lateinit var  navController : NavController

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
            navController = navHostFragment.getFragment<NavHostFragment>().navController

            cvChar.setOnClickListener{
              navController.navigate(R.id.action_homeFragment_to_characterFragment)
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