package com.sgale.chart_core.model

sealed class ChartData {
    abstract val entries: List<ChartEntryModel<out Number>>

    data class IntData(override val entries: List<ChartEntryModel<Int>>) : ChartData()
    data class LongData(override val entries: List<ChartEntryModel<Long>>) : ChartData()
    data class DoubleData(override val entries: List<ChartEntryModel<Double>>) : ChartData()
}