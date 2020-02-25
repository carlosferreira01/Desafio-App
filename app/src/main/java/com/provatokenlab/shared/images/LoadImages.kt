package com.provatokenlab.shared.images

import android.content.Context
import android.widget.ImageView
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.QueueProcessingType
import kotlin.math.roundToInt


object LoadImages {


    private fun getDisplayImageOptions(): DisplayImageOptions? {
        return DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build()
    }

    fun loadImageLoaderConfigs(context: Context) {
        val config = ImageLoaderConfiguration.Builder(context)
            .defaultDisplayImageOptions(getDisplayImageOptions())
            .tasksProcessingOrder(QueueProcessingType.FIFO)
            .diskCacheSize(150 * 1024 * 1024)
            .memoryCacheSize(25 * 1024 * 1024)
            .writeDebugLogs()
            .build()
        ImageLoader.getInstance().init(config)
    }

    fun loadImageLoaderOnImageView(imgUrl: String?, ivImage: ImageView) {
        if(imgUrl != null) {
            val imageLoader = ImageLoader.getInstance()
            imageLoader.displayImage(imgUrl, ivImage, getDisplayImageOptions())
        }
    }


}