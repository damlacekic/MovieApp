package com.damla.intershipproject2.api.popularModel

@Suppress("ConstructorParameterNaming")
data class Popular(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
