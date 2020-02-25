package com.provatokenlab.extensions

import android.app.Activity
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.annotation.ArrayRes

fun Activity.setGradientOnLayout(view: View, @ArrayRes resColors: Int) {
    val colors = resources.getIntArray(resColors)
    val drawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors)

    view.background = drawable
}