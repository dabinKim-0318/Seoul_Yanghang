package com.seoulyanghang.android.presentation.util.extension

import android.content.Context
import android.widget.Toast

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}