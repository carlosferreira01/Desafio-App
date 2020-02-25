package com.provatokenlab.shared.app

import android.content.Context
import com.provatokenlab.BuildConfig
import com.provatokenlab.R


object App {

    fun getVersionName(context: Context): String{
        return String.format (
            context.resources.getString(R.string.version_name),
            BuildConfig.VERSION_NAME
        )
    }
}