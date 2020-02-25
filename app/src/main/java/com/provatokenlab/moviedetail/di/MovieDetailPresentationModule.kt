package com.provatokenlab.moviedetail.di

import com.provatokenlab.moviedetail.MovieDetailContract
import com.provatokenlab.moviedetail.MovieDetailPresenter
import org.koin.dsl.module

val movieDetailPresentationModule = module {

    factory<MovieDetailContract.Presenter> {
            (view: MovieDetailContract.View) -> MovieDetailPresenter(mView = view, mUseCase = get())
    }
}