package com.sgale.chart_core.barchart

import com.sgale.chart_core.AbstractChartEntry
import com.sgale.chart_core.model.ChartEntryModel

class BarChartEntry <T: Number> (
    val entryModel: ChartEntryModel<T>
) : AbstractChartEntry() {

    override fun updateCurrentValue(time: Float) {
        entryModel.currentValue.plus(1)
        println("Entry label: ${entryModel.label}, current value: ${entryModel.currentValue}")
    }
}