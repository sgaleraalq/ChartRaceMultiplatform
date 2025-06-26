package com.sgale.chart_race.utils

import android.content.Context

class CsvOpener (
    private val context: Context,
    private val csvPath: String
) {
    fun openCsv(): String {
        val inputStream = context.assets.open(csvPath)
        return inputStream.bufferedReader().use { it.readText() }
    }
}