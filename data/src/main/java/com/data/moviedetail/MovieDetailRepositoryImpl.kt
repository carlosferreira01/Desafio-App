package com.data.moviedetail

import com.data.moviedetail.datasource.MovieDetailDataSource
import com.data.moviedetail.mapper.extensions.toMovieDetail
import com.domain.moviedetail.model.MovieDetail
import com.domain.moviedetail.repository.MovieDetailRepository
import io.reactivex.Single

class MovieDetailRepositoryImpl(
    private val mDataSource: MovieDetailDataSource
): MovieDetailRepository {

    override fun getMovieDetail(id: String): Single<MovieDetail> {
        return mDataSource.getMovieDetail(id).map{it.toMovieDetail()}
    }
}