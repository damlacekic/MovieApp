package com.damla.intershipproject2.util

import java.io.Serializable

interface GenreUi : ListAdapterItem, Serializable {
    override val id: Long

    val name: String
}