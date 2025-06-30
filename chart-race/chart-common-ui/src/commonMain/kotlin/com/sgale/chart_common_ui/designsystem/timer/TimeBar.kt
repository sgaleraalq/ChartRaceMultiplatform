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

package com.sgale.chart_common_ui.designsystem.timer

import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TimeBar(
    modifier: Modifier,
    timePercentage: Float,
    onTimePositionChanged: (Float) -> Unit,
    timelineItems: List<String>,
    color: Color
) {
    Column(
        modifier = modifier.fillMaxHeight().padding(end = 16.dp),
        verticalArrangement = Bottom
    ) {
        TimerPositionItem(
            timePercentage = timePercentage,
            onTimePositionChanged = { onTimePositionChanged(it) },
            color = color
        )
        TimelineBar(color)
        TimelineItems(
            modifier = Modifier.fillMaxWidth(),
            color = color,
            items = timelineItems
        )
    }
}

@Preview
@Composable
fun PreviewTimeBar() {
    Box(
        modifier = Modifier.height(50.dp)
    ) {
        TimeBar(
            modifier = Modifier.fillMaxWidth(),
            timePercentage = 0.5f,
            timelineItems = List(10) { "Item ${it + 1}" },
            onTimePositionChanged = {},
            color = TIME_BAR_COLOR,
        )
    }
}