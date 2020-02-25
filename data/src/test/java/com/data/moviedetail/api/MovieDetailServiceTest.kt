package com.data.moviedetail.api

import com.data.moviedetail.entity.MovieDetailEntity
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieDetailServiceTest {
    @Mock
    private lateinit var mMovieDetail : Single<MovieDetailEntity>

    @Mock
    private lateinit var mService: MovieDetailService

    private var movieId: String = "240"

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun saveFetchMovieDetailRepositoryTest(){
        Mockito.`when`(mService.fetchMovieDetail(movieId)).thenReturn(mMovieDetail)

        mService.fetchMovieDetail(movieId)
    }
}