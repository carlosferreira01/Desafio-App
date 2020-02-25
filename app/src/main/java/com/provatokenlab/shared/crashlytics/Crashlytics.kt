package com.provatokenlab.shared.crashlytics

import android.content.Context
import com.crashlytics.android.BuildConfig
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric

object Crashlytics {

    fun init(context: Context) {
        val crashlytics = Crashlytics.Builder()
            .core(
                CrashlyticsCore.Builder()
                    .disabled(BuildConfig.DEBUG)
                    .build()
            )
            .build()

        Fabric.with(context, crashlytics)
    }

    fun logException(throwable: Throwable) {
        if (!BuildConfig.DEBUG) {
            Crashlytics.logException(throwable)
        }
    }
}