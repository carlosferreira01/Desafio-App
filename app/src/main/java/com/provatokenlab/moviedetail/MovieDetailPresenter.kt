package com.provatokenlab.moviedetail

import com.domain.moviedetail.model.MovieDetail
import com.domain.moviedetail.usecase.MovieDetailUseCase
import com.provatokenlab.R
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.HttpURLConnection

class MovieDetailPresenter (
    private var mView: MovieDetailContract.View,
    private var mUseCase: MovieDetailUseCase): MovieDetailContract.Presenter {
    private val mDisposable = CompositeDisposable()
    private lateinit var mMovieId: String


    override fun getMovieDetail(){
        mView.showProgressbar()

        mDisposable.add(
            mUseCase.getMovieDetail(mMovieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    mView.dismissProgressbar()
                }
                .subscribe({ movies: MovieDetail? ->
                    if(movies!=null) {
                        mView.setTitleMovie(movies.title)
                        mView.setTextGenres(movies.genres.component1())
                        mView.setTextOverview(movies.overview)
                        mView.setTextRuntime(movies.runtime.toString())
                        mView.setTextVoteCout(movies.vote_count.toString())
                        mView.setTextVoteAverage(movies.vote_average.toString())
                        mView.setTextRelease(movies.release)
                        mView.setImagePoster(movies.banner)
                    } else {
                        mView.showMessageUser(R.string.message_user_not_content)
                        mView.showContainerMessageUser()
                    }
                },
                    { throwable -> if (throwable is HttpException) {
                        if (throwable.code() == HttpURLConnection.HTTP_NOT_FOUND)
                            mView.showMessageUser(R.string.message_user_not_content)
                            mView.showContainerMessageUser()
                    } else {
                        mView.showErrorMessageUser()
                        mView.showContainerMessageUser()
                    }
                        mView.showErrorMessageUser()
                        mView.showContainerMessageUser()
                    }
                )
        )
    }

    override fun setMovieId(movieId: String) {
        mMovieId = movieId
    }

    override fun setDataMovieDetail(movie: MovieDetail){
        mView.setTitleMovie(movie.title)
        mView.setTextGenres(movie.genres.component1())
        mView.setTextOverview(movie.overview)
        mView.setTextRuntime(movie.runtime.toString())
    }

    override fun destroy() {
        mDisposable.clear()
    }

}