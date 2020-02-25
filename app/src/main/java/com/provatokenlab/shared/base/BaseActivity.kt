package com.provatokenlab.shared.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.provatokenlab.R
import com.provatokenlab.extensions.setGradientOnLayout
import kotlinx.android.synthetic.main.layout_progressbar.*


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()

        setBackgroundGradientProgressbar(R.array.colors)
    }

    private fun setBackgroundGradientProgressbar(arrayColors: Int) {
        if (containerGradient != null)
            this.setGradientOnLayout(containerGradient, arrayColors)

        progressbarLoad.loadProgress(arrayColors)
    }
}