package com.damla.intershipproject2.util

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error<T>(val exception: Exception) : DataState<T>()
    data class Loading<T>(val data: T? = null) : DataState<T>()
}