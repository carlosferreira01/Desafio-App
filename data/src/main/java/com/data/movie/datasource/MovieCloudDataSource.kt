package com.data.movie.datasource

import com.data.movie.api.MovieService
import com.data.movie.entity.MovieEntity
import com.data.shared.api.ApiClient


import io.reactivex.Single

class MovieCloudDataSource(private val mClient: ApiClient):
    MovieDataSource{
    private val mService by lazy { mClient.createService(MovieService::class.java)}

    override fun getMovies(): Single<List<MovieEntity>> {
        return mService.fetchMovies()
    }

}