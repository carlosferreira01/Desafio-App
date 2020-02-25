package com.provatokenlab.fail

import android.content.Intent
import android.os.Bundle
import com.provatokenlab.R
import com.provatokenlab.application.AppController
import com.provatokenlab.extensions.createToolbar
import com.provatokenlab.shared.base.BaseActivity
import com.provatokenlab.splash.SplashScreenActivity
import kotlinx.android.synthetic.main.activity_fail.*
import kotlinx.android.synthetic.main.layout_fail.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class FailActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fail)
        this.createToolbar(toolbar, false)

        setListener()
        verifyTypeError()
    }

    private fun setListener() {
        mBtRestart.setOnClickListener {
            restartApp()
        }
    }

    private fun verifyTypeError() {
        if (intent.hasExtra(AppController.PARAM_ERROR)) {
            val messageError = intent.getStringExtra(AppController.PARAM_ERROR)
            val textError = mTvError.text.toString()

            setTextViewError(messageError, textError)
        }
    }

    private fun setTextViewError(messageError: String, textError: String) {
        mTvError.text = String.format(
            getString(R.string.activity_fail_error_occurred),
            textError,
            messageError
        )
    }

    private fun restartApp() {
        val intent = Intent(this, SplashScreenActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

}