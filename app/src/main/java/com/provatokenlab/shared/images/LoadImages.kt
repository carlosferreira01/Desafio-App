package com.provatokenlab.shared.images

import android.content.Context
import android.widget.ImageView
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.QueueProcessingType
import kotlin.math.roundToInt


object LoadImages {
    private val DEFAULT_IMG_RESOLUTION_PRODUCT = "104x78"
    private val IMG_BASE_URL = "https://a-static.mlcdn.com.br/"

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

    fun getIdealImgResolution(context: Context, idealWidth: Int, idealHeight: Int): String {
        return dpToPx(idealWidth, context).toString() + "x" + dpToPx(idealHeight, context).toString()
    }

    private fun dpToPx(dp: Int, context: Context): Int {
        val density = context.resources
            .displayMetrics
            .density
        return (dp.toFloat() * density).roundToInt()
    }

    fun setIdealResolutionInImgURL(imgURL: String?, idealImgResolution: String): String? {
        var imgURL: String? = imgURL ?: return null
        if (imgURL!!.contains(IMG_BASE_URL)) {
            val image = imgURL.replace(DEFAULT_IMG_RESOLUTION_PRODUCT, idealImgResolution)
            imgURL = image.replace("{w}x{h}", idealImgResolution)
        }
        return imgURL
    }

}