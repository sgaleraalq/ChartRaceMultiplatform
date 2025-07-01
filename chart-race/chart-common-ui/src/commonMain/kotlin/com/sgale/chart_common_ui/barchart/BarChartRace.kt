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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.sgale.chart_common_ui.designsystem.background.drawBackgroundInterval
import com.sgale.chart_core.barchart.BarChart
import com.sgale.chart_core.utils.DataType

@Composable
fun BarChartRace(
    csvData: String,
    dataType: DataType,
    numberOfEntries: Int
) {
    val density = LocalDensity.current
    val barChart = BarChart(csvData, dataType)
    var chartHeight by remember { mutableStateOf(0.dp) }

    Box(
        modifier = Modifier.fillMaxWidth().onGloballyPositioned { layoutCoordinates ->
            chartHeight = with(density) {
                layoutCoordinates.size.height.toDp()
            }
        }
    ) {
        Canvas(
            modifier = Modifier.fillMaxWidth().height(chartHeight)
        ){
            drawBackgroundInterval(
                color = Gray,
                xPosition = 0.5f,
                height = chartHeight
            )
        }
        Column {
            BarChartRow(barChart, numberOfEntries)
        }
    }
}

@Composable
fun BarChartRow(
    barChart: BarChart,
    entries: Int
) {
    Column(
        modifier = Modifier
            .padding(24.dp)
    ) {
        barChart.chartData.entries
            .take(entries)
            .forEach { entry ->
                Text(
                    text = entry.label,
                    color = Black
                )
            }
    }
}
