package com.sgale.chart_core

import com.sgale.chart_core.csv.CsvParser

abstract class AbstractChart(
    private val csvParser: CsvParser
) : ChartEntry {

    private lateinit var chartData: List<ChartEntryModel>

    init {

    }

}