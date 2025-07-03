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
import com.sgale.chart_core.model.ChartData
import com.sgale.chart_core.utils.DataType
import com.sgale.chart_core.utils.DataType.DOUBLE
import com.sgale.chart_core.utils.DataType.INT
import com.sgale.chart_core.utils.DataType.LONG
import com.sgale.chart_core.utils.Timer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AbstractChart(
    data: String,
    dataType: DataType,
    timer: Timer
) : ChartEntry {

    private val csvParser = CsvParser()

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    init {
        coroutineScope.launch {
            timer.timePercentage.collect { progress ->
                println("Timer progress: $progress")
            }
        }
    }


    val chartData: ChartData = when (dataType) {
        INT -> {
            val parsed = csvParser.parseCsvAsInt(data).values.sortedByDescending { it.currentValue }
            println("This is my chartData: $parsed")
            ChartData.IntData(parsed)
        }
        DOUBLE -> {
            val parsed = csvParser.parseCsvAsDouble(data).values.sortedByDescending { it.currentValue }
            println("This is my chartData: $parsed")
            ChartData.DoubleData(parsed)
        }
        LONG -> {
            val parsed = csvParser.parseCsvAsLong(data).values.sortedByDescending { it.currentValue }
            println("This is my chartData: $parsed")
            ChartData.LongData(parsed)
        }
    }


}
