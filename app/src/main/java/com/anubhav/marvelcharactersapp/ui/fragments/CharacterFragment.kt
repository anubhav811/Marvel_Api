package com.anubhav.marvelcharactersapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anubhav.marvelcharactersapp.ui.MarvelViewModelFactory
import com.anubhav.marvelcharactersapp.R
import com.anubhav.marvelcharactersapp.adapters.CharacterAdapter
import com.anubhav.marvelcharactersapp.databinding.FragmentCharacterBinding
import com.anubhav.marvelcharactersapp.domain.repository.MarvelRepository
import com.anubhav.marvelcharactersapp.ui.MarvelViewModel
import com.anubhav.marvelcharactersapp.util.Resource
import kotlinx.android.synthetic.main.fragment_character.*


class CharacterFragment : Fragment(R.layout.fragment_character) {
    private val TAG = "CharacterFragment"
    lateinit var viewModel: MarvelViewModel
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
        viewModel = ViewModelProvider(this,viewModelProvider).get(MarvelViewModel::class.java)
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

                }
            })


    }
    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    val scrollListener = object : RecyclerView.OnScrollListener(){

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as GridLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount  = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtBeginning = firstVisibleItemPosition >=0

            val isTotalMoreThanVisible = totalItemCount >= 100

            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning && isTotalMoreThanVisible && isScrolling

            if(shouldPaginate){
                val page = viewModel.characterPage
                viewModel.getCharacters(page*200)
                isScrolling = false
            }

        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                isScrolling = true

        }



    }

    private fun setupRecyclerView(){
        characterAdapter = CharacterAdapter()
        rvChar.apply{
            adapter = characterAdapter
            layoutManager = GridLayoutManager(activity,3)
        }
    }

}

