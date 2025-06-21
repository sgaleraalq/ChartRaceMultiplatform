package com.sgale.chart_race

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform