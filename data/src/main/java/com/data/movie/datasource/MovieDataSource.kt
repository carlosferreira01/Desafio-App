package com.data.movie.datasource

import com.data.movie.entity.MovieEntity
import io.reactivex.Single


interface MovieDataSource {

        fun getMovies(): Single<List<MovieEntity>>

}