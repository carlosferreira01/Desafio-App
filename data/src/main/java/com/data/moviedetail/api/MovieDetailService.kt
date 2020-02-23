package com.data.moviedetail.api

import com.data.movie.entity.MovieEntity
import com.data.moviedetail.entity.MovieDetailEntity
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieDetailService {
    @Headers("Content-Type: application/json")
    @GET("movies")
    fun fetchMovieDetail(
        //@Header("Authorization") token: String
        @Query("id") id: Int
        // @Query("offset") offset: Int?
    ): List<MovieDetailEntity>
}