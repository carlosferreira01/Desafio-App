package com.data.movie.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieEntity (
    val id: Int,
    val title: String,
    @SerializedName("poster_url")val image: String?,
    val genres: List<String>,
    @SerializedName("vote_average")val average: Double,
    @SerializedName("release_date")val date: String
): Serializable