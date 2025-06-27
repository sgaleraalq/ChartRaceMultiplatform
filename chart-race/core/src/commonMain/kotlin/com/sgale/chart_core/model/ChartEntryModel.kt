package com.sgale.chart_core.model

data class ChartEntryModel <T: Number>(
    val id: String,
    val label: String,
    val currentValue: T?,
    val values: Map<String, T>
)