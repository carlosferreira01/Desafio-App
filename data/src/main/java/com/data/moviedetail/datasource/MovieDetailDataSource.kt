package com.data.moviedetail.datasource

import com.data.moviedetail.entity.MovieDetailEntity
import io.reactivex.Single


interface MovieDetailDataSource {
    fun getMovieDetail(id: String): Single<MovieDetailEntity>
}