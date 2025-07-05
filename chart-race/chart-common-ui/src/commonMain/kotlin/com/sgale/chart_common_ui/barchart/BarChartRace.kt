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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.sgale.chart_common_ui.designsystem.background.drawBackgroundInterval
import com.sgale.chart_core.barchart.BarChart
import com.sgale.chart_core.barchart.BarChartEntry
import com.sgale.chart_core.utils.DataType
import com.sgale.chart_core.utils.Timer

@Composable
fun BarChartRace(
    csvData: String,
    dataType: DataType,
    numberOfEntries: Int,
    timer: Timer
) {
    val density = LocalDensity.current
    val barChart = BarChart(timer, csvData, dataType)
    var chartHeight by remember { mutableStateOf(0.dp) }

    val chartEntries = remember { mutableStateOf(barChart.barChartData) }

    Box(
        modifier = Modifier.fillMaxWidth().onGloballyPositioned { layoutCoordinates ->
            chartHeight = with(density) {
                layoutCoordinates.size.height.toDp()
            }
        }
    ) {
        Canvas(
            modifier = Modifier.fillMaxWidth().height(chartHeight)
        ) {
            drawBackgroundInterval(
                color = Gray,
                xPosition = 0.5f,
                height = chartHeight
            )
        }
        Column {
            BarChartRow(chartEntries.value, numberOfEntries)
        }
    }
}

@Composable
fun BarChartRow(
    chartData: List<BarChartEntry<out Number>>,
    entries: Int
) {
    Column(
        modifier = Modifier
            .padding(24.dp)
    ) {
        chartData
            .take(entries)
            .forEach { entry ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = entry.entryModel.label,
                        color = Black
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = entry.entryModel.currentValue.toString(),
                        color = Black
                    )
                }
            }
    }
}
