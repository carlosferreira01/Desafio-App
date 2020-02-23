package com.data.movie

import com.data.movie.datasource.MovieDataSource
import com.data.movie.mapper.extensions.toMovies
import com.domain.movie.model.Movie
import com.domain.movie.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl(
    private val mDataSource: MovieDataSource
): MovieRepository {

    override fun getMovies(): Single<List<Movie>> {
        return mDataSource.getMovies().map{it.toMovies()}
    }
}