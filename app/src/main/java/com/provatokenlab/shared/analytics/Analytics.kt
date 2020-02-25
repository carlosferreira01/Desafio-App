package com.provatokenlab.shared.analytics

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import io.reactivex.annotations.NonNull

object Analytics {
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics

    fun init(@NonNull context: Context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    fun logEvent(@NonNull eventName: String, bundle: Bundle?) {
        mFirebaseAnalytics.logEvent(eventName, bundle)
    }

    fun logErrorEvent(description: String?, isFatal: Boolean) {
        val bundle = Bundle()
        bundle.putString("message", description)
        bundle.putBoolean("fatal", isFatal)
        mFirebaseAnalytics.logEvent("exception", bundle)
    }

}