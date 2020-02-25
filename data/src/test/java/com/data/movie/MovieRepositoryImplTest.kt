package com.data.movie

import com.data.movie.datasource.MovieDataSource
import com.data.movie.entity.MovieEntity
import com.data.movie.mock.MovieMock
import com.domain.movie.model.Movie
import com.domain.movie.repository.MovieRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieRepositoryImplTest {
    val mThrowable = Throwable("error")
    private lateinit var mMovieEntity : List<MovieEntity>

    @Mock
    private lateinit var mDataSource: MovieDataSource

    private lateinit var mRepository: MovieRepository

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        mRepository = MovieRepositoryImpl(mDataSource)

        mMovieEntity = MovieMock.getListMovies()

    }

    @Test
    fun getMoviesInfo_ok() {
        Mockito.`when`(
            mDataSource.getMovies()
        ).thenReturn(Single.just(mMovieEntity))

        val testObserver: TestObserver<List<Movie>> = mRepository.getMovies().test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun getMoviesInfo_error() {
        Mockito.`when`(
            mDataSource.getMovies()
        ).thenReturn(Single.error(mThrowable))

        val testObserver: TestObserver<List<Movie>> = mRepository.getMovies().test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertError(mThrowable)
            .assertTerminated()
    }
}