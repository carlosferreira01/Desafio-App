package com.data.movie.api

import com.data.movie.entity.MovieEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieService {
    @Headers("Content-Type: application/json")
    @GET("movies")
    fun fetchMovies(
        //@Header("Authorization") token: String
        // @Query("limit") limit: Int?,
        // @Query("offset") offset: Int?
    ): Single<List<MovieEntity>>
}