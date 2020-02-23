package com.data.shared.api


import com.data.BuildConfig
import com.data.shared.enums.Environment


object BuildType {

    fun getEnvironmentBuildType() : Environment {
        return when (BuildConfig.BUILD_TYPE) {
            "debug" -> Environment.STAGE
            else -> Environment.PRODUCTION
        }
    }
}
