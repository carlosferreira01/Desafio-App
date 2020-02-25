package com.provatokenlab.extensions

import android.view.Menu
import androidx.annotation.MenuRes
import androidx.appcompat.widget.Toolbar
import com.provatokenlab.shared.base.BaseActivity

fun BaseActivity.createToolbar(toolbar: Toolbar?, displayEnabled : Boolean) {
    setSupportActionBar(toolbar)

    val actionBar = supportActionBar
    actionBar?.setDisplayHomeAsUpEnabled(displayEnabled)
}

fun BaseActivity.createOptionsMenu(menu: Menu?, @MenuRes menuID: Int){
    menuInflater.inflate(menuID, menu)
}

