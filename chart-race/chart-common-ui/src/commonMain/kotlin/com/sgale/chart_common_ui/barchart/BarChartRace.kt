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

package com.sgale.chart_common_ui.barchart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import com.sgale.chart_core.barchart.BarChart
import com.sgale.chart_core.utils.Configuration.BAR_HEIGHT
import com.sgale.chart_core.utils.DataType
import com.sgale.chart_core.utils.Timer

@Composable
fun BarChartRace(
    csvData: String,
    dataType: DataType,
    numberOfEntries: Int,
    timer: Timer
) {
    val barChart = remember { BarChart(timer, csvData, dataType) }
    val entries = barChart.barChartData.take(numberOfEntries)

    val currentValues = entries.map { it.currentValue.collectAsState() }
    val chartHeight = (numberOfEntries * BAR_HEIGHT).dp
    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(chartHeight)
    ) {
        val barSpacing = BAR_HEIGHT.dp.toPx()

        entries.forEachIndexed { index, entry ->
            val value = currentValues[index].value
            val barTop = index * barSpacing
            val barHeight = barSpacing * 0.8f

            println("Value: ${entry.entryModel.label}: $value")
            // Barra
            drawBar(
                x = value,
                y = barTop,
                height = barHeight
            )
        }
    }
}
