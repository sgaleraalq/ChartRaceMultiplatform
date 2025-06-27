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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.sgale.chart_core.barchart.BarChart
import com.sgale.chart_core.utils.Configuration.BAR_HEIGHT
import com.sgale.chart_core.utils.DataType

@Composable
fun BarChartRace(
    csvData: String,
    dataType: DataType,
    numberOfEntries: Int
) {
    val barChart = BarChart(csvData, dataType)

    Column {
        BarChartRow(barChart, numberOfEntries)
    }
}

@Composable
fun BarChartRow(
    barChart: BarChart,
    entries: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
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
