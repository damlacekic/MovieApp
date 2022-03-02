package com.damla.intershipproject2.fragments.detailFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.damla.intershipproject2.api.ApiRepository
import com.damla.intershipproject2.api.detailModel.Detail
import com.damla.intershipproject2.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val apiRepository: ApiRepository,
) : ViewModel() {

    var detailMovieData = MutableStateFlow<DataState<Detail>>(DataState.Loading())

    @Suppress("TooGenericExceptionCaught")
    fun getDetails(movieID: Int): StateFlow<DataState<Detail>> {
        detailMovieData.value = DataState.Loading()
        viewModelScope.launch {
            try {
                val responseDetail = apiRepository.getDetail(movieID)
                detailMovieData.value = DataState.Success(responseDetail)
            } catch (e: Exception) {
                detailMovieData.value = DataState.Error(e)
            }
        }
        return detailMovieData
    }
}
