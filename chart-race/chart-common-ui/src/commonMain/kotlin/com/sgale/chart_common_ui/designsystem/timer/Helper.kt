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

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun TimerPositionItem(
    timePercentage: Float,
    color: Color
) {
    val arrowHeight = 10.dp
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(arrowHeight)
    ) {
        val totalWidthPx = with(LocalDensity.current) { maxWidth.toPx() }

        val arrowSizePx = with(LocalDensity.current) { arrowHeight.toPx() }
        val xOffset = (totalWidthPx * timePercentage - arrowSizePx / 2).toInt()

        Box(
            modifier = Modifier
                .offset { IntOffset(x = xOffset, y = 0) }
                .size(arrowHeight)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val width = size.width
                val height = size.height

                val path = Path().apply {
                    moveTo(width / 2f, height)
                    lineTo(0f, 0f)
                    lineTo(width, 0f)
                    close()
                }

                drawPath(path = path, color = color)
            }
        }
    }
}
