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
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.max
import kotlin.math.roundToInt

@Composable
fun TimerPositionItem(
    timePercentage: Float,
    onTimePositionChanged: (Float) -> Unit = {},
    color: Color
) {
    val arrowHeight = 10.dp
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val down = awaitFirstDown()
                        val percentage = (down.position.x / size.width).coerceIn(0f, 1f)
                        onTimePositionChanged(percentage)
                    }
                }
            }
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

@Composable
fun TimelineBar(color: Color) {
    Canvas(
        modifier = Modifier.fillMaxWidth().height(1.dp)
    ) {
        drawLine(
            color = color,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = size.height
        )
    }
}

val BAR_SMALL_SIZE = 3.5.dp
val BAR_LARGE_SIZE = 10.dp

@Composable
fun TimelineItems(
    modifier: Modifier = Modifier,
    color: Color,
    items: List<String>
) {
    val positions = getTimelinePositions(items)
    val textMeasurer = rememberTextMeasurer()

    val sampleTextLayout = textMeasurer.measure(
        text = "Item",
        style = TextStyle(fontSize = 10.sp)
    )
    val textHeight = with(LocalDensity.current) { sampleTextLayout.size.height.toDp() }
    val totalHeight = BAR_LARGE_SIZE + textHeight + 4.dp

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(totalHeight)
    ) {
        val idealHighlightCount = (size.width / 80f).coerceAtLeast(2f)

        val intervalForHighlight = when {
            items.size <= 10 -> 1
            items.size <= 25 -> 3
            items.size <= 40 -> 4
            items.size <= 50 -> 5
            else -> max(1, items.size / idealHighlightCount.roundToInt())
        }

        positions.forEachIndexed { index, pos ->
            val isHighlighted = index % intervalForHighlight == 0
            val label = items.getOrNull(index) ?: ""

            drawTimeline(
                color = color,
                position = pos,
                timelineHeight = if (isHighlighted) {
                    BAR_LARGE_SIZE
                } else {
                    BAR_SMALL_SIZE
                },
                textMeasurer = textMeasurer,
                label = label,
                showText = isHighlighted
            )
        }
    }
}

fun DrawScope.drawTimeline(
    color: Color,
    position: Float,
    timelineHeight: Dp,
    textMeasurer: TextMeasurer,
    label: String = "",
    showText: Boolean = false
) {
    val x = size.width * position
    val barHeight = timelineHeight.toPx()

    drawLine(
        color = color,
        start = Offset(x, 0f),
        end = Offset(x, barHeight),
        strokeWidth = 1.dp.toPx()
    )

    if (showText) {
        val textLayout = textMeasurer.measure(
            text = label,
            style = TextStyle(
                color = color,
                fontSize = 10.sp
            )
        )

        drawText(
            textLayoutResult = textLayout,
            topLeft = Offset(
                x - textLayout.size.width / 2f,
                barHeight + 1.dp.toPx()
            )
        )
    }
}

private fun getTimelinePositions(items: List<String>): List<Float> =
    List(items.size) { index ->
        index.toFloat() / (items.size - 1)
    }.takeIf { it.isNotEmpty() } ?: listOf(0f, 1f)
