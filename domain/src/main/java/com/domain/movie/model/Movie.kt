package com.domain.movie.model

import java.io.Serializable

data class Movie (
    val id: String,
    val title: String,
    val image: String?,
    val genres: List<String>,
    val average: Double,
    val date: String
): Serializable