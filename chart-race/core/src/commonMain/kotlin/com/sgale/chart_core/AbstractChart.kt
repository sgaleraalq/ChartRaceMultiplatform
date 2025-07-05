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

package com.sgale.chart_core

import com.sgale.chart_core.csv.CsvParser
import com.sgale.chart_core.utils.DataType
import com.sgale.chart_core.utils.DataType.DOUBLE
import com.sgale.chart_core.utils.DataType.INT
import com.sgale.chart_core.utils.DataType.LONG
import com.sgale.chart_core.utils.Timer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AbstractChart (
    private val timer: Timer,
    data: String,
    dataType: DataType,
) : IChart {

    private val parser = CsvParser()
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    init {
        parseChartData(data, dataType)
        observeTimer()
    }

    private fun parseChartData(data: String, dataType: DataType) {
        when (dataType) {
            INT -> {
                val parsedData = parser.parseCsvAsInt(data).values
                    .sortedByDescending { it.currentValue }
                initChartData(parsedData)
            }
            DOUBLE -> {
                val parsedData = parser.parseCsvAsDouble(data).values
                    .sortedByDescending { it.currentValue }
                initChartData(parsedData)
            }
            LONG -> {
                val parsedData = parser.parseCsvAsLong(data).values
                    .sortedByDescending { it.currentValue }
                initChartData(parsedData)
            }
        }
    }

    private fun observeTimer() {
        coroutineScope.launch {
            timer.timePercentage.collect { progress ->
                onNewPosition(progress)
            }
        }
    }
}
