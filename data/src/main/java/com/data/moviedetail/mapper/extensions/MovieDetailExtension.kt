package com.data.moviedetail.mapper.extensions

import com.data.moviedetail.entity.MovieDetailEntity
import com.domain.moviedetail.model.MovieDetail

fun List<MovieDetailEntity>.toMovieDetail(): List<MovieDetail> =
    map {
        it.toMovieDetail() }


fun MovieDetailEntity.toMovieDetail() = MovieDetail(
    id = id,
    title = title,
    image = image,
    banner = banner,
    overview = overview,
    vote_average = vote_average,
    vote_count = vote_count,
    genres = genres

)