package com.provatokenlab.splash

import androidx.annotation.StringRes

interface SplashScreenContract {
    interface View {
        fun showHomeActivity()
        fun showMessageUser(@StringRes resId: Int)
        fun finishApp()
    }

    interface Presenter {
        fun setHomeActivity()
        fun destroy()
    }

}