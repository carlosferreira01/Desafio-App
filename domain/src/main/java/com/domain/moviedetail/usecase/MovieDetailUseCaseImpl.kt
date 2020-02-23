package com.domain.moviedetail.usecase

import com.domain.moviedetail.model.MovieDetail
import com.domain.moviedetail.repository.MovieDetailRepository

class MovieDetailUseCaseImpl(
    private val mRepository: MovieDetailRepository): MovieDetailUseCase {

    override fun getMovieDetail(id: Int): List<MovieDetail> {
        return mRepository.getMovieDetail(id)
    }

}