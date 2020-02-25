package com.data.moviedetail

import com.data.moviedetail.datasource.MovieDetailDataSource
import com.data.moviedetail.entity.MovieDetailEntity
import com.data.moviedetail.mock.MovieDetailMock
import com.domain.moviedetail.model.MovieDetail
import com.domain.moviedetail.repository.MovieDetailRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieDetailRepositoryImplTest {
    val mThrowable = Throwable("error")
    private lateinit var mMovieDetailEntity : MovieDetailEntity

    @Mock
    private lateinit var mDataSource: MovieDetailDataSource

    private lateinit var mRepository: MovieDetailRepository
    private var movieId: String = "240"

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        mRepository = MovieDetailRepositoryImpl(mDataSource)

        mMovieDetailEntity = MovieDetailMock.getMovieDetail()

    }

    @Test
    fun getMovieDetailInfo_ok() {
        Mockito.`when`(
            mDataSource.getMovieDetail(movieId)
        ).thenReturn(Single.just(mMovieDetailEntity))

        val testObserver: TestObserver<MovieDetail> = mRepository.getMovieDetail(movieId).test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun getMovieDetailInfo_error() {
        Mockito.`when`(
            mDataSource.getMovieDetail(movieId)
        ).thenReturn(Single.error(mThrowable))

        val testObserver: TestObserver<MovieDetail> = mRepository.getMovieDetail(movieId).test()
        testObserver.awaitTerminalEvent()

        testObserver
            .assertError(mThrowable)
            .assertTerminated()
    }
}