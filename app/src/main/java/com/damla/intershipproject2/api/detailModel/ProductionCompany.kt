package com.damla.intershipproject2.api.detailModel

@Suppress("ConstructorParameterNaming")
data class ProductionCompany(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val origin_country: String
)
