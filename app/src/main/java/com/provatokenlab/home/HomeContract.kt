package com.provatokenlab.home

import com.domain.movie.model.Movie

interface HomeContract {
    interface View{

        fun showProgressbar()
        fun dismissProgressbar()
        fun showContainerMessageUser()
        fun showErrorMessageUser()
        fun dismissRecyclerViewList()
        fun showMessageUser(resId: Int)
        fun setMoviesAdapter(movies: List<Movie>)
    }

    interface Presenter{
        fun getMovies()
        fun destroy()
    }
}