package com.sgale.chart_common_ui.barchart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sgale.chart_core.barchart.BarChart
import com.sgale.chart_core.utils.DataType

@Composable
fun BarChartRace(
    csvData: String,
    dataType: DataType,
) {
    val barChart = BarChart(csvData, dataType)

    Column {
        BarChartRow(barChart)
    }
}

@Composable
fun BarChartRow(
    barChart: BarChart
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        barChart.chartData.entries.forEach { entry ->
            Row {
                Text(text = entry.label)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = entry.currentValue.toString())
            }
        }
    }
}
