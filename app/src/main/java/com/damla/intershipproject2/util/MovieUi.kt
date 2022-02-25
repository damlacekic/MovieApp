package com.damla.intershipproject2.util

import java.io.Serializable
import java.util.*

interface MovieUi : ListAdapterItem, Serializable{

    override val id: Long

    val title: String

    val overview: String

    val genres: List<GenreUi>

    val posterPath: String?

    val average: Double

    val releaseDate: Date?

    val averageString: String get() = average.toString()



    val genreString: String
        get() = genres.joinToString(separator = ", ", limit = 3, truncated = "") { it.name }

    companion object {
        const val DATE_FORMAT_SHOW = "dd.MM.yyyy"
    }
}