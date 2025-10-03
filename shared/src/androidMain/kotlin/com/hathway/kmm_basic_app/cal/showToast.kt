package com.hathway.kmm_basic_app.cal


import android.content.Context
import android.widget.Toast

lateinit var appContext: Context

fun initContext(context: Context) {
    appContext = context
}

actual fun showToast(message: String) {
    Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show()
}