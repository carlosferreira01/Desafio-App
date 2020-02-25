package com.domain.moviedetail.model

import java.io.Serializable

data class MovieDetail (
    val id: String,
    val title: String,
    val image: String,
    val banner: String,
    val overview: String,
    val vote_average: Double,
    val vote_count: Int,
    val genres: List<String>,
    val runtime: Int,
    val release: String

): Serializable