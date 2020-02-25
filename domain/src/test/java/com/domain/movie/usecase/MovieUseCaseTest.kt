package com.domain.movie.usecase

import com.domain.movie.mock.MovieMockDomain
import com.domain.movie.model.Movie
import com.domain.movie.repository.MovieRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieUseCaseTest {
    val mThrowable = Throwable("error")

    @Mock
    private lateinit var mRespository: MovieRepository

    private lateinit var mUseCase: MovieUseCase

    private lateinit var mMovie: List<Movie>


    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)


        mUseCase = MovieUseCaseImpl(mRespository)

        mMovie = MovieMockDomain.getListMovies()

    }

    @Test
    fun getMovieInfo_ok() {

        Mockito.`when`(
            mRespository.getMovies()
        ).thenReturn(Single.just(mMovie))

        val testObserver: TestObserver<List<Movie>> = mUseCase.getMovies().test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertNoErrors()
            .assertComplete()

    }

    @Test
    fun getMovieInfo_error() {

        Mockito.`when`(
            mRespository.getMovies()
        ).thenReturn(Single.error(mThrowable))

        val testObserver: TestObserver<List<Movie>> = mUseCase.getMovies().test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertError(mThrowable)
    }
}