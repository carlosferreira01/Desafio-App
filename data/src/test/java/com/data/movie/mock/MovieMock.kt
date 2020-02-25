package com.data.movie.mock

import com.data.movie.entity.MovieEntity

object MovieMock {


    fun getListMovies(): List<MovieEntity>{
        val list:MutableList<MovieEntity> = ArrayList()
        list.add(movie())
        list.add(movie())

        return list
    }


    private fun movie(): MovieEntity {
        return MovieEntity(
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