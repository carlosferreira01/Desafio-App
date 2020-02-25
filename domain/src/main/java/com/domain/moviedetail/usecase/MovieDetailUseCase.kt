package com.domain.moviedetail.usecase

import com.domain.moviedetail.model.MovieDetail
import io.reactivex.Single

interface MovieDetailUseCase {
    fun getMovieDetail(id: String): Single<MovieDetail>
}