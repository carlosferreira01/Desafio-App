package com.data.movie.mapper.extensions

import com.data.movie.entity.MovieEntity
import com.domain.movie.model.Movie
import io.reactivex.Single

fun List<MovieEntity>.toMovies(): List<Movie> =
    map {
        it.toMovies() }


fun MovieEntity.toMovies() = Movie(
    id = id,
    title = title,
    image = image,
    genres = genres,
    average = average,
    date = date
)