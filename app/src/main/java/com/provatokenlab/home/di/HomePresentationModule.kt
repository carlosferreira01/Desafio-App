package com.provatokenlab.home.di

import com.provatokenlab.home.HomeContract
import com.provatokenlab.home.HomePresenter
import org.koin.dsl.module

val homePresentationModule = module {

    factory<HomeContract.Presenter> {
            (view: HomeContract.View) -> HomePresenter(mView = view, mMovieUseCase = get())
    }
}