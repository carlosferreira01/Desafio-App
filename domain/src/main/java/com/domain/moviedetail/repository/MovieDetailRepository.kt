package com.domain.moviedetail.repository

import com.domain.moviedetail.model.MovieDetail

interface MovieDetailRepository {

    fun getMovieDetail(id: Int): List<MovieDetail>
}