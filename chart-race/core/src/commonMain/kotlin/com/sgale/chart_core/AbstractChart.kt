package com.sgale.chart_core

import com.sgale.chart_core.csv.CsvParser
import com.sgale.chart_core.csv.ICsvParser

abstract class AbstractChart(
    private val data: String
) : ChartEntry, ICsvParser {

    private val csvParser = CsvParser()

    private val chartData: List<ChartEntryModel> by lazy {
        csvParser.parseCsv(data)
    }

    init {
        println("this is my chart data: $chartData")
    }
}
