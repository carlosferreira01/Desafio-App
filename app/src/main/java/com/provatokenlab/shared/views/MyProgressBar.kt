package com.provatokenlab.shared.views

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ArrayRes
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar

class MyProgressBar(context: Context, attrs: AttributeSet) : SmoothProgressBar(context, attrs) {

    fun loadProgress(@ArrayRes resColors: Int) {
        val colors = resources.getIntArray(resColors)

        setSmoothProgressDrawableSectionsCount(colors.size)
        setSmoothProgressDrawableUseGradients(true)
        setSmoothProgressDrawableColors(colors)
    }
}