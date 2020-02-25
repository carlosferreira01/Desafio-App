package com.provatokenlab.moviedetail

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import com.domain.moviedetail.model.MovieDetail
import com.domain.moviedetail.usecase.MovieDetailUseCase
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.provatokenlab.RxImmediateSchedulerRule
import com.provatokenlab.moviedetail.mock.MovieDetailMockPresenter
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.internal.util.reflection.FieldSetter

class MovieDetailPresenterTest{
    @Rule
    @JvmField var testSchedulerRule = RxImmediateSchedulerRule()

    private lateinit var mView: MovieDetailContract.View
    private lateinit var mPresenter: MovieDetailContract.Presenter
    private lateinit var mUseCase: MovieDetailUseCase
    private lateinit var mMovie: MovieDetail
    private var movieId: String = "240"

    @Mock
    private lateinit var mContext: Context

    @Mock
    private lateinit var mockContextResources: Resources

    @Mock
    private lateinit var mPackageManager: PackageManager

    @Mock
    private lateinit var mDisposable: CompositeDisposable

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        mDisposable = CompositeDisposable()

        mView = mock()
        mUseCase = mock()
        mMovie = MovieDetailMockPresenter.getMovieDetail()

        mPresenter = MovieDetailPresenter(mView, mUseCase)

        Mockito.`when`(
            mockContextResources.getString(ArgumentMatchers.anyInt())
        ).thenReturn("")

        Mockito.`when`(
            mContext.resources
        ).thenReturn(mockContextResources)

        Mockito.`when`(
            mContext.packageManager
        ).thenReturn(mPackageManager)


    }

    @Test
    fun getMovies_success(){
        FieldSetter.setField(mPresenter, mPresenter.javaClass.getDeclaredField("mMovieId"), movieId)

        Mockito.`when`(
            mUseCase.getMovieDetail(movieId)
        ).thenReturn(Single.just(MovieDetailMockPresenter.getMovieDetail()))

        mPresenter.getMovieDetail()

        inOrder(mView){
            verify(mView).showProgressbar()
            verify(mView).setTitleMovie(mMovie.title)
            verify(mView).setTextGenres(mMovie.genres.component1())
            verify(mView).setTextOverview(mMovie.overview)
            verify(mView).setTextRuntime(mMovie.runtime.toString())
            verify(mView).setTextVoteCout(mMovie.vote_count.toString())
            verify(mView).setTextVoteAverage(mMovie.vote_average.toString())
            verify(mView).setTextRelease(mMovie.release)
            verify(mView).setImagePoster(mMovie.banner)
            verify(mView).dismissProgressbar()
            verifyNoMoreInteractions()
        }

    }


    @Test
    fun getMovies_error(){
        val messageError = "msgError"
        FieldSetter.setField(mPresenter, mPresenter.javaClass.getDeclaredField("mMovieId"), movieId)

        Mockito.`when`(
            mUseCase.getMovieDetail(movieId)
        ).thenReturn(Single.error(Throwable(messageError)))

        mPresenter.getMovieDetail()

        inOrder(mView){
            verify(mView).showProgressbar()
            verify(mView).showErrorMessageUser()
            verify(mView).showContainerMessageUser()
            verify(mView).dismissProgressbar()
            verifyNoMoreInteractions()
        }
    }
}