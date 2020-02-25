package com.domain.movie.mock

import com.domain.movie.model.Movie

object MovieMockDomain {
    fun getListMovies(): List<Movie>{
        val list:MutableList<Movie> = ArrayList()
        list.add(movie())
        list.add(movie())

        return list
    }


    private fun movie(): Movie {
        return Movie(
            id = "240",
            title = "The Godfather: Part II",
            image = "https://image.tmdb.org/t/p/w200/bVq65huQ8vHDd1a4Z37QtuyEvpA.jpg",
            genres = genres(),
            average = 8.5,
            date = "1974-12-20"
        )
    }

    fun genres(): List<String>{
        val list:MutableList<String> = ArrayList()
        list.add(genre())
        list.add(genre())

        return list
    }

    private fun genre(): String{
        return "Comedy"
    }
}