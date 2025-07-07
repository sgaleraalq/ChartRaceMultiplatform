package com.sgale.chart_core

abstract class AbstractChartEntry : IChartEntry {
//    /**
//     * Updates the current value of the chart entry based on the provided time.
//     * This method should be implemented by subclasses to define how the current value is updated.
//     *
//     * @param time The time at which the current value should be updated.
//     */
//    abstract override fun updateCurrentValue(time: Float)

    abstract val id: String
    abstract val label: String
}