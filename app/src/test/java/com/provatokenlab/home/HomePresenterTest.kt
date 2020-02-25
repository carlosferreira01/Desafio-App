package com.provatokenlab.home

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import com.domain.movie.model.Movie
import com.domain.movie.usecase.MovieUseCase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.isNotNull
import com.provatokenlab.RxImmediateSchedulerRule
import com.provatokenlab.home.mock.HomeMockPresenter
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class HomePresenterTest {
    @Rule
    @JvmField var testSchedulerRule = RxImmediateSchedulerRule()

    private lateinit var mView: HomeContract.View
    private lateinit var mPresenter: HomeContract.Presenter
    private lateinit var mUseCase: MovieUseCase
    private lateinit var mMovie: List<Movie>

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
        mMovie = HomeMockPresenter.getListMovies()

        mPresenter = HomePresenter(mView, mUseCase)

        `when`(
            mockContextResources.getString(ArgumentMatchers.anyInt())
        ).thenReturn("")

        `when`(
            mContext.resources
        ).thenReturn(mockContextResources)

        `when`(
            mContext.packageManager
        ).thenReturn(mPackageManager)


    }

    @Test
    fun getMovies_success(){

        `when`(
            mUseCase.getMovies()
        ).thenReturn(Single.just(HomeMockPresenter.getListMovies()))

        mPresenter.getMovies()

        inOrder(mView){
            verify(mView).showProgressbar()
            verify(mView).setMoviesAdapter(mMovie)
            verify(mView).dismissProgressbar()
            verifyNoMoreInteractions()
        }

    }


    @Test
    fun getMovies_error(){
        val messageError = "msgError"

        `when`(
            mUseCase.getMovies()
        ).thenReturn(Single.error(Throwable(messageError)))

        mPresenter.getMovies()

        inOrder(mView){
            verify(mView).showProgressbar()
            verify(mView).showErrorMessageUser()
            verify(mView).showContainerMessageUser()
            verify(mView).dismissRecyclerViewList()
            verify(mView).dismissProgressbar()
            verifyNoMoreInteractions()
        }
    }
}