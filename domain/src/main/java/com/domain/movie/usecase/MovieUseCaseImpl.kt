package com.domain.movie.usecase

import com.domain.movie.model.Movie
import com.domain.movie.repository.MovieRepository
import io.reactivex.Single

class MovieUseCaseImpl(
    private val mRepository: MovieRepository
): MovieUseCase {

    override fun getMovies(): Single<List<Movie>> {
        return mRepository.getMovies()
    }

}