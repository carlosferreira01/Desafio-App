package com.provatokenlab.moviedetail

import com.domain.moviedetail.model.MovieDetail

interface MovieDetailContract {
    interface View{

        fun dismissProgressbar()
        fun showContainerMessageUser()
        fun showMessageUser(resId: Int)
        fun showProgressbar()
        fun setTitleMovie(title: String)
        fun setTextGenres(genres: String)
        fun setTextRuntime(runtime: String)
        fun setTextOverview(overview: String)
        fun setTextRelease(release: String)
        fun setTextVoteCout(vote_count: String)
        fun setTextVoteAverage(vote_average: String)
        fun showErrorMessageUser()
        fun setImagePoster(image: String)
    }


    interface Presenter{


        fun setMovieId(movieId: String)
        fun destroy()
        fun getMovieDetail()
        fun setDataMovieDetail(movie: MovieDetail)
    }
}