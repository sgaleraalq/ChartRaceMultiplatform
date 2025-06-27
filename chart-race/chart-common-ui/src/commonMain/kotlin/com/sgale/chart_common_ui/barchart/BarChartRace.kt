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
    val density = LocalDensity.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        barChart.chartData.entries
            .take(entries)
            .forEach { entry ->
                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .height(BAR_HEIGHT.dp)
                        .weight(entry.currentPercentage)
                        .background(Red)
                )
            }
//        barChart.chartData.entries.forEach { entry ->
//            Row {
//                Text(text = entry.label)
//                Spacer(modifier = Modifier.weight(1f))
//                Text(text = entry.currentValue.toString())
//            }
//        }
    }
}
