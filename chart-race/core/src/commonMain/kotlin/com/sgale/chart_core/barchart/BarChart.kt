/*
 * Designed and developed by 2025 sgaleraalq (Sergio Galera)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sgale.chart_core.barchart

import com.sgale.chart_core.AbstractChart
import com.sgale.chart_core.model.ChartEntryModel
import com.sgale.chart_core.utils.DataType
import com.sgale.chart_core.utils.Timer

class BarChart (
    timer: Timer,
    csvData: String,
    dataType: DataType,
    showEntries: Int
) : AbstractChart(timer, csvData, dataType) {

    lateinit var barChartData: List<BarChartEntry<out Number>>

    override fun <T : Number> initChartData(data: List<ChartEntryModel<T>>) {
        barChartData = data.map { entryModel ->
            BarChartEntry(entryModel)
        }
    }

    override fun onNewPosition(time: Float) {
        updateAllCurrentValues(time)
    }

    private fun updateAllCurrentValues(time: Float) {
        barChartData.forEach {
            it.updateCurrentValue(time)
        }
    }
}
