package com.provatokenlab.splash

import android.content.Context
import com.android.volley.VolleyLog.TAG
import io.reactivex.disposables.CompositeDisposable

class SplashScreenPresenter(
    private val mView: SplashScreenContract.View) : SplashScreenContract.Presenter {

    private var mDisposable = CompositeDisposable()

    override fun setHomeActivity(){
        mView.showHomeActivity()
    }

    override fun destroy() {
        mDisposable.clear()
    }

}