package com.data.moviedetail.datasource

import com.data.moviedetail.entity.MovieDetailEntity


interface MovieDetailDataSource {
    fun getMovieDetail(id: Int): List<MovieDetailEntity>
}