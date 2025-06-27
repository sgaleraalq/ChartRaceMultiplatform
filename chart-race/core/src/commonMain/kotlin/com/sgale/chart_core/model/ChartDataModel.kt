package com.sgale.chart_core.model

data class ChartDataModel <T: Number> (
    val values: List<ChartEntryModel<T>>
)