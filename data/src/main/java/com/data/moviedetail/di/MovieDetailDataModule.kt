package com.data.moviedetail.di

import com.data.movie.datasource.MovieCloudDataSource
import com.data.movie.datasource.MovieDataSource
import com.data.moviedetail.MovieDetailRepositoryImpl
import com.data.moviedetail.datasource.MovieDetailCloudDataSource
import com.data.moviedetail.datasource.MovieDetailDataSource
import com.data.shared.api.ApiClient
import com.domain.moviedetail.repository.MovieDetailRepository
import org.koin.dsl.module

val movieDetailRepositoryModule = module {
    factory<MovieDetailRepository> {
        MovieDetailRepositoryImpl(
            mDataSource = get()
        )
    }
}


val movieDetailPreferencesModule = module {
    factory<MovieDetailDataSource> {
        MovieDetailCloudDataSource(
            mClient = ApiClient()
        )
    }
}

val movieDetailDataModules = listOf(movieDetailRepositoryModule, movieDetailPreferencesModule)