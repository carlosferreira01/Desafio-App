package com.provatokenlab.moviedetail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.domain.movie.model.Movie
import com.domain.moviedetail.model.MovieDetail
import com.provatokenlab.R
import com.provatokenlab.extensions.createToolbar
import com.provatokenlab.extensions.executeTransitionInOut
import com.provatokenlab.shared.base.BaseActivity
import com.provatokenlab.shared.images.LoadImages
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_detail.layoutAverage
import kotlinx.android.synthetic.main.activity_movie_detail.mTextNameMovie
import kotlinx.android.synthetic.main.layout_adapter_home.*
import kotlinx.android.synthetic.main.layout_progressbar.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MovieDetailActivity: BaseActivity(), MovieDetailContract.View{
    private val mPresenter: MovieDetailContract.Presenter by inject { parametersOf(this) }
    private var mMovie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        this.executeTransitionInOut(false)
        LoadImages.loadImageLoaderConfigs(this)


        getExtras(intent.extras)
        mPresenter.setMovieId(mMovie!!.id)
        createToolbar(toolbar, true)

        mPresenter.getMovieDetail()

    }

    private fun getExtras(extras: Bundle?){
        mMovie = extras?.getSerializable("movie") as Movie?
    }

    override fun showProgressbar() {
        progressbarLoad.visibility = View.VISIBLE
        progressbarLoad.progressiveStart()
    }

    override fun dismissProgressbar() {
        progressbarLoad.visibility = View.GONE
        progressbarLoad.progressiveStop()
    }

    override fun setTitleMovie(title : String){
        mTextNameMovie.text = title
    }

    override fun setTextGenres(genres: String){
        mTextGenre.text = genres
        layoutGenre.visibility = View.VISIBLE
    }

    override fun setTextRuntime(runtime: String){
        mTextRuntime.text = String.format(
            resources.getString(R.string.text_runtime_concatenate),
            runtime
        )
    }

    override fun setTextRelease(release: String){
        mTextReleaseMovie.text = String.format(
            resources.getString(R.string.text_release_concatenate),
            release.substring(0,4)
        )
    }

    override fun setTextVoteCout(vote_count: String){
        mTextVoteCount.text = String.format(
            resources.getString(R.string.text_vote_count_concatenate),
            vote_count
        )
    }

    override fun setTextVoteAverage(vote_average: String){
        mTextAverageMovie.text = vote_average
        layoutAverage.visibility = View.VISIBLE
        viewSeparate.visibility = View.VISIBLE
    }

    override fun setTextOverview(overview: String){
        mTextOverview.text = overview
    }

    override fun setImagePoster(image: String){
        LoadImages.loadImageLoaderOnImageView(image, mPosterMovie)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                else -> finish()
            }
        }
        return true
    }

    override fun onDestroy() {
        mPresenter.destroy()
        super.onDestroy()
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
    override fun finish() {
        super.finish()
        this.executeTransitionInOut(true)
    }


}