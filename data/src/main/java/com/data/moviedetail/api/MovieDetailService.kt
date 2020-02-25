package com.data.moviedetail.api

import com.data.moviedetail.entity.MovieDetailEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailService {
    @Headers("Content-Type: application/json")
    @GET("movies/{id}")
    fun fetchMovieDetail(
        //@Header("Authorization") token: String
        @Path("id") id: String
        // @Query("offset") offset: Int?
    ): Single<MovieDetailEntity>
}