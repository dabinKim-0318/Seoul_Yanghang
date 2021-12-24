package com.seoulyanghang.android

import android.app.Application
import com.seoulyanghang.android.util.PixelRatio
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SeoulYanghangApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initPixelUtil()
    }

    private fun initPixelUtil() {
        pixelRatio = PixelRatio(this)
    }

    companion object {
        lateinit var pixelRatio: PixelRatio
    }
}

