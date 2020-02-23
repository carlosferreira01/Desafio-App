package com.data.shared.api

import com.data.shared.enums.Environment


object BaseUrl {

    private const val MOVIE_STAGE_ENDPOINT = "https://desafio-mobile.nyc3.digitaloceanspaces.com/"
    private const val MOVIE_PRODUCTION_ENDPOINT = "https://desafio-mobile.nyc3.digitaloceanspaces.com/"

    fun getUrl(environment: Environment): String {
        return when(environment) {
            Environment.STAGE -> MOVIE_STAGE_ENDPOINT
            Environment.PRODUCTION -> MOVIE_PRODUCTION_ENDPOINT
        }
    }

}