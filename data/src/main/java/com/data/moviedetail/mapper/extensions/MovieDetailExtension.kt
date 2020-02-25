package com.data.moviedetail.mapper.extensions

import com.data.moviedetail.entity.MovieDetailEntity
import com.domain.moviedetail.model.MovieDetail
import io.reactivex.Single

fun MovieDetailEntity.toMovieDetail() = MovieDetail(
    id = id,
    title = title,
    image = image,
    banner = banner,
    overview = overview,
    vote_average = vote_average,
    vote_count = vote_count,
    genres = genres,
    runtime = runtime,
    release = release
)