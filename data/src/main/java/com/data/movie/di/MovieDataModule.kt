package com.data.movie.di

import com.data.movie.MovieRepositoryImpl
import com.data.movie.datasource.MovieCloudDataSource
import com.data.movie.datasource.MovieDataSource
import com.data.shared.api.ApiClient
import com.domain.movie.repository.MovieRepository
import org.koin.dsl.module

val movieRepositoryModule = module {
    factory<MovieRepository> {
        MovieRepositoryImpl(
            mDataSource = get()
        )
    }
}


val moviePreferencesModule = module {
    factory<MovieDataSource> {
        MovieCloudDataSource(
            mClient = ApiClient()
        )
    }
}

val movieDataModules = listOf(movieRepositoryModule, moviePreferencesModule)