package com.provatokenlab.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat.getExtras
import androidx.recyclerview.widget.LinearLayoutManager
import com.domain.movie.model.Movie
import com.provatokenlab.R
import com.provatokenlab.extensions.createToolbar
import com.provatokenlab.extensions.executeTransitionInOut
import com.provatokenlab.home.adapter.HomeAdapter
import com.provatokenlab.moviedetail.MovieDetailActivity
import com.provatokenlab.shared.adapter.RecyclerViewAdapter
import com.provatokenlab.shared.base.BaseActivity
import com.provatokenlab.shared.images.LoadImages
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_progressbar.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.io.Serializable


class HomeActivity : BaseActivity(), HomeContract.View, RecyclerViewAdapter.OnItemClickListener<Movie>{
    private val mPresenter: HomeContract.Presenter  by inject { parametersOf(this) }
    private var mDisposableView = CompositeDisposable()
    private var mAdapter: HomeAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        getExtras(intent)
        this.executeTransitionInOut(false)
        this.createToolbar(toolbar, false)
        LoadImages.loadImageLoaderConfigs(this)

        initRecyclerView()
        mPresenter.getMovies()

    }

    @SuppressLint("WrongConstant")
    private fun initRecyclerView() {
        mRvProducts.setHasFixedSize(true)
        mRvProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun setMoviesAdapter(movies: List<Movie>) {
        mAdapter = HomeAdapter(this, movies)
        mAdapter?.setOnItemClickListener(this)
        mRvProducts.adapter = mAdapter

    }

    override fun onItemClick(movie: Movie, position: Int) {
        startMovieDetailActivity(movie)
    }

    private fun startMovieDetailActivity(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movie", movie as Serializable)
        startActivity(intent)
    }

    override fun showProgressbar() {
        progressbarLoad.visibility = View.VISIBLE
        progressbarLoad.progressiveStart()
    }

    override fun dismissProgressbar() {
        progressbarLoad.visibility = View.GONE
        progressbarLoad.progressiveStop()
    }

    override fun showContainerMessageUser(){
        mContentMessage.visibility = View.VISIBLE
    }

    override fun showErrorMessageUser() {
        mTvMessage.text = resources.getString(R.string.message_error_user_caused_exception)
    }

    override fun showMessageUser(resId: Int) {
        mTvMessage.text = getString(resId)
    }

    override fun dismissRecyclerViewList(){
        mRvProducts.visibility = View.GONE
    }

    override fun finish() {
        super.finish()
        this.executeTransitionInOut(true)
    }

    override fun onDestroy() {
        mPresenter.destroy()
        super.onDestroy()
        mDisposableView.clear()
    }
}