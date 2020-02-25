package com.data.moviedetail.mock

import com.data.moviedetail.entity.MovieDetailEntity

object MovieDetailMock {
    fun getMovieDetail(): MovieDetailEntity{
        return movie()
    }


    private fun movie(): MovieDetailEntity {
        return MovieDetailEntity(
            id = "240",
            title = "The Godfather: Part II",
            banner = "https://image.tmdb.org/t/p/w200/bVq65huQ8vHDd1a4Z37QtuyEvpA.jpg",
            image = "https://image.tmdb.org/t/p/w500/gLbBRyS7MBrmVUNce91Hmx9vzqI.jpg",
            genres = genres(),
            overview = "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.",
            vote_count = 4794,
            vote_average = 8.5,
            runtime = 200,
            release = "1974-12-20"
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