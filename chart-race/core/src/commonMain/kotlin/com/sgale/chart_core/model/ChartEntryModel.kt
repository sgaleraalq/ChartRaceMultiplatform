package com.sgale.chart_core.model

data class ChartEntryModel <T: Number>(
    val id: String,
    val label: String,
    val currentValue: T?,
    val currentPercentage: Float,
    val values: Map<String, T>
)