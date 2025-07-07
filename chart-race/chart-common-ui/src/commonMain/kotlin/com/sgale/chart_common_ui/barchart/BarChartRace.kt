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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import com.sgale.chart_core.barchart.BarChart
import com.sgale.chart_core.barchart.BarChartEntry
import com.sgale.chart_core.model.ChartEntryModel
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
    val barChart = remember { BarChart(timer, csvData, dataType, numberOfEntries) }
    val entries = barChart.barChartData.take(numberOfEntries)


    val chartHeight = (numberOfEntries * BAR_HEIGHT).dp

    Column {
        entries.forEach {
            MyText(
                it
            )
        }
    }

//    Canvas(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(chartHeight)
//    ) {
//        val barSpacing = BAR_HEIGHT.dp.toPx()
//
//        entries.forEachIndexed { index, entry ->
//            val value = currentValues[index]
//            val barTop = index * barSpacing
//            val barHeight = barSpacing * 0.8f
//
//            println("Value: ${entry.entryModel.label}: $value")
//            drawBar(
//                x = value,
//                y = barTop,
//                height = barHeight
//            )
//        }
//    }
}

@Composable
fun MyText(
    data: BarChartEntry<out Number>
) {
    val label = data.label
    val currentValue = data.currentValue.collectAsState().value
    Row {
        Text(
            text = label
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = currentValue.toString()
        )
    }
}
