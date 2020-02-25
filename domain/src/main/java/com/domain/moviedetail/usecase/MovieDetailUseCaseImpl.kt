package com.domain.moviedetail.usecase

import com.domain.moviedetail.model.MovieDetail
import com.domain.moviedetail.repository.MovieDetailRepository
import io.reactivex.Single

class MovieDetailUseCaseImpl(
    private val mRepository: MovieDetailRepository): MovieDetailUseCase {

    override fun getMovieDetail(id: String): Single<MovieDetail> {
        return mRepository.getMovieDetail(id)
    }

}