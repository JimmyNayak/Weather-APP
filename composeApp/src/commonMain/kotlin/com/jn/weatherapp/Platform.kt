package com.jn.weatherapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform