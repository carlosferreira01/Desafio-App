package com.data.moviedetail.entity

import java.io.Serializable

data class MovieDetailEntity(
    val id: Int,
    val title: String,
    val image: String,
    val banner: String,
    val overview: String,
    val vote_average: Double,
    val vote_count: Int,
    val genres: String

): Serializable
