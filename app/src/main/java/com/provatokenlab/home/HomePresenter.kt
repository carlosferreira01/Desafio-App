package com.provatokenlab.home

import com.domain.movie.model.Movie
import com.domain.movie.usecase.MovieUseCase
import com.provatokenlab.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.HttpURLConnection

class HomePresenter(
    private val mView: HomeContract.View,
    private val mMovieUseCase: MovieUseCase) : HomeContract.Presenter {
    private val mDisposable = CompositeDisposable()


    override fun getMovies(){

        mView.showProgressbar()

        mDisposable.add(
            mMovieUseCase.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    mView.dismissProgressbar()
                }
                .subscribe ({ movies: List<Movie>? ->
                    if(!movies.isNullOrEmpty())
                        mView.setMoviesAdapter(movies)
                    else
                    {
                        mView.showMessageUser(R.string.message_user_not_content)
                        mView.showContainerMessageUser()
                        mView.dismissRecyclerViewList()
                    }
                },
                    { throwable -> if (throwable is HttpException) {
                        if (throwable.code() == HttpURLConnection.HTTP_NOT_FOUND)
                            mView.showMessageUser(R.string.message_user_not_content)
                        else
                            mView.showErrorMessageUser()
                    } else {
                        mView.showErrorMessageUser()
                    }

                        mView.showContainerMessageUser()
                        mView.dismissRecyclerViewList()
                    }
                )
        )
    }

    override fun destroy() {
        mDisposable.clear()
    }

}