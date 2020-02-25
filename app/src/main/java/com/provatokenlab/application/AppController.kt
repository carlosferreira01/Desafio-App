package com.provatokenlab.application

import android.content.Intent
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.data.movie.di.movieDataModules
import com.data.moviedetail.di.movieDetailDataModules
import com.domain.movie.di.movieDomainModule
import com.domain.moviedetail.di.movieDetailDomainModule
import com.provatokenlab.fail.FailActivity
import com.provatokenlab.home.di.homePresentationModule
import com.provatokenlab.moviedetail.di.movieDetailPresentationModule
import com.provatokenlab.shared.analytics.Analytics
import com.provatokenlab.shared.crashlytics.Crashlytics
import com.provatokenlab.splash.di.splashScreenPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.system.exitProcess

class AppController: MultiDexApplication() {
    private lateinit var mInstance: AppController

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        Thread.setDefaultUncaughtExceptionHandler { _, exception ->
            Analytics.logErrorEvent(exception.message, true)

            handleUncaughtException(exception)
        }

        mInstance = this

        //Crashlytics.init(this@AppController)
        //Analytics.init(this)

        startKoin {
            androidContext(this@AppController)

               modules ( splashScreenPresentationModule + homePresentationModule + movieDomainModule + movieDataModules +
                       movieDetailDomainModule + movieDetailDataModules + movieDetailPresentationModule)
        }

    }

    @Synchronized
    fun getInstance(): AppController {
        return mInstance
    }

    private fun handleUncaughtException(exception: Throwable) {
        val stringWriter = StringWriter()
        exception.printStackTrace(PrintWriter(stringWriter))

        val intent = Intent(this, FailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra(PARAM_ERROR, stringWriter.toString())
        startActivity(intent)

        exitProcess(PARAM_STATUS_EXIT_PROCESS)
    }

    companion object {
        const val PARAM_ERROR = "error"
        const val PARAM_STATUS_EXIT_PROCESS = 1
    }
}