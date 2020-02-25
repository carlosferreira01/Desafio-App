package com.domain.moviedetail.usecase

import com.domain.moviedetail.mock.MovieDetailMockDomain
import com.domain.moviedetail.model.MovieDetail
import com.domain.moviedetail.repository.MovieDetailRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieDetailUseCaseTest {
    val mThrowable = Throwable("error")

    @Mock
    private lateinit var mRespository: MovieDetailRepository

    private lateinit var mUseCase: MovieDetailUseCase

    private lateinit var mMovieDetail: MovieDetail
    private var movieId: String = "240"


    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)


        mUseCase = MovieDetailUseCaseImpl(mRespository)

        mMovieDetail = MovieDetailMockDomain.getMovieDetail()

    }

    @Test
    fun getMovieInfo_ok() {

        Mockito.`when`(
            mRespository.getMovieDetail(movieId)
        ).thenReturn(Single.just(mMovieDetail))

        val testObserver: TestObserver<MovieDetail> = mUseCase.getMovieDetail(movieId).test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertNoErrors()
            .assertComplete()

    }

    @Test
    fun getMovieInfo_error() {

        Mockito.`when`(
            mRespository.getMovieDetail(movieId)
        ).thenReturn(Single.error(mThrowable))

        val testObserver: TestObserver<MovieDetail> = mUseCase.getMovieDetail(movieId).test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertError(mThrowable)
    }
}