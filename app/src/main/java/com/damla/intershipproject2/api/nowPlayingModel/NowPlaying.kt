package com.damla.intershipproject2.api.nowPlayingModel

@Suppress("ConstructorParameterNaming")
data class NowPlaying(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
