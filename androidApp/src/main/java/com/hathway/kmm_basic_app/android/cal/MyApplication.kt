package com.hathway.kmm_basic_app.android.cal

import android.app.Application
import com.hathway.kmm_basic_app.cal.initContext


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initContext(this) // initialize context for Toast
    }
}