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
import com.sgale.chart_core.model.ChartData
import com.sgale.chart_core.model.ChartData.DoubleData
import com.sgale.chart_core.model.ChartData.IntData
import com.sgale.chart_core.model.ChartData.LongData
import com.sgale.chart_core.model.ChartEntryModel
import com.sgale.chart_core.utils.DataType
import com.sgale.chart_core.utils.Timer

class BarChart (
    timer: Timer,
    csvData: String,
    dataType: DataType,
) : AbstractChart(timer, csvData, dataType) {

    private var barChartData: List<ChartEntryModel<out Number>>

    init {
        barChartData = when (val data = chartData) {
            is IntData -> data.entries
            is DoubleData -> data.entries
            is LongData -> data.entries
        }
        println("this is my data $barChartData")
    }

    override fun <T : Number> initChartData(data: List<ChartEntryModel<T>>) {
        barChartData = data
    }

    override fun onNewPosition(time: Float) {
        println("New position at time: $time")
    }
}
