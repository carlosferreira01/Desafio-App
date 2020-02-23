package com.domain.movie.usecase

import com.domain.movie.model.Movie
import io.reactivex.Single

interface MovieUseCase {
    fun getMovies(): Single<List<Movie>>
}