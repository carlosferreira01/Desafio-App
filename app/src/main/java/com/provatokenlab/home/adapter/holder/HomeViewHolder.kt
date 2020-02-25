package com.provatokenlab.home.adapter.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_adapter_home.view.*

class HomeViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    val mTextNameMovie: TextView = itemView.mTextNameMovie
    val mImageMovie: ImageView = itemView.mImageMovie
    val mTextGenres: TextView = itemView.mTextGenres
    val mTextRelease: TextView = itemView.mTextRelease
    val mTextAverage: TextView = itemView.mTextAverage

}