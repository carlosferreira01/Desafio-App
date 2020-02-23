package com.domain.movie.di

import com.domain.movie.model.Movie
import com.domain.movie.usecase.MovieUseCase
import com.domain.movie.usecase.MovieUseCaseImpl
import org.koin.dsl.module

val movieUseCaseModule = module {

    factory<MovieUseCase> {
        MovieUseCaseImpl(mRepository = get())
    }

}

val movieDomainModule = listOf(movieUseCaseModule)