package com.data.moviedetail.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDetailEntity(
    val id: String,
    val title: String,
    @SerializedName("backdrop_url")val image: String,
    @SerializedName("poster_url") val banner: String,
    val overview: String,
    val vote_average: Double,
    val vote_count: Int,
    val genres: List<String>,
    val runtime: Int,
    @SerializedName("release_date") val release: String

): Serializable
