package com.damla.intershipproject2.fragments.movieFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.damla.intershipproject2.R
import com.damla.intershipproject2.adapters.RecyclerViewAdapter
import com.damla.intershipproject2.adapters.ViewPagerAdapter
import com.damla.intershipproject2.api.popularModel.Result
import com.damla.intershipproject2.databinding.FragmentMainBinding
import com.damla.intershipproject2.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mViewModel: MainViewModel by viewModels()
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var popularMovieList:List<Result>
    private lateinit var nowPlayingMovieList:List<com.damla.intershipproject2.api.nowPlayingModel.Result>
    private lateinit var mViewPagerAdaptor : ViewPagerAdapter

    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        manager = LinearLayoutManager(requireContext())
        lifecycleScope.launchWhenCreated {
            mViewModel.getNowPlaying().collect { dataState ->
                when (dataState) {
                    is DataState.Success -> {
                        val nowPlayingMovieData = dataState.data
                        nowPlayingMovieList = nowPlayingMovieData.results
                        if(::nowPlayingMovieList.isInitialized){
                            if(!nowPlayingMovieList.isEmpty()){
                                mViewPagerAdaptor = ViewPagerAdapter(nowPlayingMovieList)
                                binding.viewPagerNowPlayingShow.adapter = mViewPagerAdaptor
                                binding.viewPagerNowPlayingShow.offscreenPageLimit = 3
                                binding.viewPagerNowPlayingShow.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                                val pageMArgin = resources.getDimensionPixelSize(R.dimen.margin_now_playing_page)
                                val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset_now_playing_page)
                                binding.viewPagerNowPlayingShow.setPageTransformer { page, position ->
                                    val offset = -(2* pageOffset + pageMArgin) * position
                                    page.translationX = offset
                                }

                               //binding.viewPagerNowPlayingShow.adapter = ViewPagerAdapter(nowPlayingMovieList)
                            }
                        }

                    }
                    is DataState.Error -> {
                        println(dataState.exception)
                    }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            mViewModel.getPopular().collect { dataState ->
                when(dataState){
                    is DataState.Success ->{
                        val popularMovieData = dataState.data
                        popularMovieList = popularMovieData.results
                        if(::popularMovieList.isInitialized){
                            if(!popularMovieList.isEmpty()){
                                binding.recyclerView.apply {
                                    adapter = RecyclerViewAdapter(popularMovieList)
                                    layoutManager = manager
                                }

                            }
                        }


                    }
                    is DataState.Error -> {
                        println(dataState.exception)
                    }
                }

            }
        }

//        }

        return binding.root
    }


}