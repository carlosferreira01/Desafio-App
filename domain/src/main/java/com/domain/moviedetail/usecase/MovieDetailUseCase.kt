package com.domain.moviedetail.usecase

import com.domain.moviedetail.model.MovieDetail

interface MovieDetailUseCase {
    fun getMovieDetail(id: Int): List<MovieDetail>
}