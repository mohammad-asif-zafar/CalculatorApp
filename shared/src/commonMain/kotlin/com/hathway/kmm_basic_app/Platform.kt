package com.hathway.kmm_basic_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
