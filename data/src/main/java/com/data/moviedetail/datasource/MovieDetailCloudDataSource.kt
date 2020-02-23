package com.data.moviedetail.datasource


import com.data.moviedetail.api.MovieDetailService
import com.data.moviedetail.entity.MovieDetailEntity
import com.data.shared.api.ApiClient

class MovieDetailCloudDataSource(private val mClient: ApiClient):
    MovieDetailDataSource {
    private val mService by lazy { mClient.createService(MovieDetailService::class.java)}

    override fun getMovieDetail(id: Int): List<MovieDetailEntity> {
        return mService.fetchMovieDetail(id)
    }

}