package com.domain.movie.repository

import com.domain.movie.model.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(): Single<List<Movie>>
}