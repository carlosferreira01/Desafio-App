package com.domain.moviedetail.di

import com.domain.moviedetail.usecase.MovieDetailUseCase
import com.domain.moviedetail.usecase.MovieDetailUseCaseImpl
import org.koin.dsl.module

val movieDetailUseCaseModule = module {

    factory<MovieDetailUseCase> {
        MovieDetailUseCaseImpl(mRepository = get())
    }

}

val movieDetailDomainModule = listOf(movieDetailUseCaseModule)