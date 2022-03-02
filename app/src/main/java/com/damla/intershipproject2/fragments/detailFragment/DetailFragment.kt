package com.damla.intershipproject2.fragments.detailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.damla.intershipproject2.R
import com.damla.intershipproject2.api.detailModel.Detail
import com.damla.intershipproject2.api.detailModel.Genre
import com.damla.intershipproject2.databinding.FragmentDetailBinding
import com.damla.intershipproject2.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val mViewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    private lateinit var genreList: List<Genre>
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val id: Int = args.movieId
        lifecycleScope.launchWhenCreated {
            mViewModel.getDetails(id).collect { dataState ->
                when (dataState) {
                    is DataState.Success -> {
                        binding.detail = dataState.data
                        binding.textViewRating.text = dataState.data.vote_average.toString()
                        binding.textViewRuntime.text = dataState.data.runtime.toString() + " min"
                        genreList = dataState.data.genres
                        if (::genreList.isInitialized) {
                            if (!genreList.isEmpty()) {

                                binding.textViewGenres.text = genreList.joinToString(
                                    separator = ", ",
                                    limit = 3,
                                    truncated = ""
                                ) { it.name }

                            }

                        }


                    }
                    is DataState.Error -> {
                        println(dataState.exception)
                    }
                }

            }
        }
        return binding.root
    }
}
