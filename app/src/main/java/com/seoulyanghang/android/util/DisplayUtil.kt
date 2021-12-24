package com.seoulyanghang.android.util

import android.app.Application
import androidx.annotation.Px
import com.seoulyanghang.android.SeoulYanghangApplication
import kotlin.math.roundToInt


class PixelRatio(private val app: Application) {
    private val displayMetrics
        get() = app.resources.displayMetrics

    val screenWidth
        get() = displayMetrics.widthPixels

    val screenHeight
        get() = displayMetrics.heightPixels

    val screenShort
        get() = screenWidth.coerceAtMost(screenHeight)

    val screenLong
        get() = screenWidth.coerceAtLeast(screenHeight)

    @Px
    fun toPixel(dp: Int) = (dp * displayMetrics.density).roundToInt()

    fun toDP(@Px pixel: Int) = (pixel / displayMetrics.density).roundToInt()
}

val Number.pixel: Int
    @Px get() = SeoulYanghangApplication.pixelRatio.toDP(this.toInt())

val Number.dp: Int
    get() = SeoulYanghangApplication.pixelRatio.toPixel(this.toInt())

val Number.pixelFloat: Float
    @Px get() = SeoulYanghangApplication.pixelRatio.toDP(this.toInt()).toFloat()

val Number.dpFloat: Float
    get() = SeoulYanghangApplication.pixelRatio.toPixel(this.toInt()).toFloat()
