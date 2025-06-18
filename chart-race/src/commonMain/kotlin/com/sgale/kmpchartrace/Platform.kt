package com.sgale.kmpchartrace

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform