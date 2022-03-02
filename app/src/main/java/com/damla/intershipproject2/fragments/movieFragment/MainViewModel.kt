package com.damla.intershipproject2.fragments.movieFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damla.intershipproject2.api.ApiRepository
import com.damla.intershipproject2.api.nowPlayingModel.NowPlaying
import com.damla.intershipproject2.api.popularModel.Popular
import com.damla.intershipproject2.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
) : ViewModel() {


    var nowPlayingMovieData = MutableStateFlow<DataState<NowPlaying>>(DataState.Loading())
    var popularMovieData = MutableStateFlow<DataState<Popular>>(DataState.Loading())

    @Suppress("TooGenericExceptionCaught")
    fun getNowPlaying(): StateFlow<DataState<NowPlaying>> {
        nowPlayingMovieData.value = DataState.Loading()
        viewModelScope.launch {
            try {
                val responseNowPlaying = apiRepository.getNowPlaying()
                nowPlayingMovieData.value = DataState.Success(responseNowPlaying)

            } catch (e: Exception) {
                nowPlayingMovieData.value = DataState.Error(e)
            }
        }
        return nowPlayingMovieData

    }

    fun getPopular(): StateFlow<DataState<Popular>> {
        popularMovieData.value = DataState.Loading()
        viewModelScope.launch {
            try {
                val responsePopular = apiRepository.getPopular()
                popularMovieData.value = DataState.Success(responsePopular)
            } catch (e: java.lang.Exception) {
                popularMovieData.value = DataState.Error(e)
            }
        }
        return popularMovieData
    }


}
