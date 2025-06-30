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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import com.sgale.chart_common_ui.barchart.BarChartRace
import com.sgale.chart_common_ui.designsystem.timer.TimerItem
import com.sgale.chart_common_ui.linechart.LineChartRace
import com.sgale.chart_core.utils.DataType
import com.sgale.chart_core.utils.Timer

@Composable
fun ChartRace(
    csvData: String,
    chartType: ChartType = ChartType.BAR_CHART,
    dataType: DataType = DataType.LONG,
    numberOfEntries: Int = 10
) {
    val timelineItems = remember {
        val listSize = (5..50).random()
        val startYear = (1900..2020).random()
        List(listSize) { index ->
            (startYear + index).toString()
        }
    }

    val timer = remember { Timer(timelineItems.size) }

    val timePercentage by timer.timePercentage.collectAsState()
    val isPlaying by timer.isPlaying.collectAsState()

    println("timelineItems = $timelineItems")
    println("Timer: timePercentage = $timePercentage")

    Column(
        modifier = Modifier.background(White)
    ) {
        when (chartType) {
            ChartType.BAR_CHART -> BarChartRace(csvData, dataType, numberOfEntries)
            ChartType.LINE_CHART -> LineChartRace(csvData, dataType)
        }
        TimerItem(
            isPlaying = isPlaying,
            timePercentage = timePercentage,
            onTimeStarted = { timer.startTime() },
            onTimePaused = { timer.pauseTime() },
            onTimePositionChanged = { timer.onTimePositionChanged(it) },
            timelineItems = timelineItems,
        )
    }
}
