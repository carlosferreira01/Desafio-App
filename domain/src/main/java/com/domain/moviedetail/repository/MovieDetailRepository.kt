package com.domain.moviedetail.repository

import com.domain.moviedetail.model.MovieDetail
import io.reactivex.Single

interface MovieDetailRepository {

    fun getMovieDetail(id: String): Single<MovieDetail>
}