package com.data.movie.api

import com.data.movie.entity.MovieEntity
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieServiceTest {
    @Mock
    private lateinit var mMovie : Single<List<MovieEntity>>

    @Mock
    private lateinit var mService: MovieService

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun saveFetchMovieRepositoryTest(){
        Mockito.`when`(mService.fetchMovies()).thenReturn(mMovie)

        mService.fetchMovies()
    }
}