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

package com.sgale.chart_common_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sgale.chart_core.barchart.BarChart
import com.sgale.chart_core.csv.CsvParser
import com.sgale.chart_core.utils.DataType

@Composable
fun BarChartRace(
    csvData: String,
    dataType: DataType = DataType.LONG
) {
    val parser = CsvParser()
    val barChart = when (dataType) {
        DataType.INT -> BarChart(csvData, parser::parseCsvAsInt)
        DataType.DOUBLE -> BarChart(csvData, parser::parseCsvAsDouble)
        DataType.LONG -> BarChart(csvData, parser::parseCsvAsLong)
    }

    Column {
        BarChartRow(barChart)
    }
}

@Composable
fun BarChartRow(
    barChart: BarChart<*>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(24.dp)
    ) {
        barChart.chartData.values.forEach { entry ->
            Row {
                Text(text = entry.label)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = entry.currentValue.toString())
            }
        }
    }
}