package com.provatokenlab.splash.di

import com.provatokenlab.splash.SplashScreenContract
import com.provatokenlab.splash.SplashScreenPresenter
import org.koin.dsl.module

val splashScreenPresentationModule = module {

    factory<SplashScreenContract.Presenter> {
            (view: SplashScreenContract.View) -> SplashScreenPresenter(mView = view)
    }
}