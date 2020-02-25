package com.provatokenlab.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.domain.movie.model.Movie
import com.provatokenlab.R
import com.provatokenlab.home.adapter.holder.HomeViewHolder
import com.provatokenlab.shared.adapter.RecyclerViewAdapter
import com.provatokenlab.shared.images.LoadImages

class HomeAdapter(
    private val mContext: Context,
    private var mList: List<Movie>): RecyclerViewAdapter<HomeViewHolder, Movie>(mList) {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_adapter_home, viewGroup, false)

        return createItemClick(view, HomeViewHolder(view))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val movie = mList[position]

        holder.mTextNameMovie.text = movie.title


        holder.mTextGenres.text = movie.genres.component1()


        holder.mTextRelease.text = String.format(
            mContext.resources.getString(R.string.text_release_concatenate),
            movie.date.substring(0,4)
        )

        holder.mTextAverage.text = movie.average.toString()

        if(movie.image != null) {
            LoadImages.loadImageLoaderOnImageView(movie.image, holder.mImageMovie)
        }
    }
}