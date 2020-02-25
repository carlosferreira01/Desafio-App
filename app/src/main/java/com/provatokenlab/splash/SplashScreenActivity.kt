package com.provatokenlab.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.provatokenlab.R
import com.provatokenlab.home.HomeActivity
import kotlinx.android.synthetic.main.layout_progressbar.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import com.provatokenlab.shared.base.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashScreenActivity : BaseActivity(), SplashScreenContract.View {
    private val mPresenter: SplashScreenContract.Presenter by inject { parametersOf(this) }
    //private var isOpenAppFromAction: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startProgressbarGradient()

        mPresenter.setHomeActivity()
    }

    private fun startProgressbarGradient() {
        progressbarLoad.visibility = View.VISIBLE
        progressbarLoad.progressiveStart()
    }

    override fun showHomeActivity() {
        Handler().postDelayed({
            run {
                startActivity<HomeActivity>(
                )
                finish()
            }
        }, 500)
    }

    override fun showMessageUser(resId: Int) {
        longToast(getString(resId))
    }

    override fun finishApp() {
        finish()
    }

    override fun onDestroy() {
        mPresenter.destroy()
        super.onDestroy()
    }

//    override fun finish() {
//        super.finish()
//        this.executeTransitionInOut(true)
//    }
}