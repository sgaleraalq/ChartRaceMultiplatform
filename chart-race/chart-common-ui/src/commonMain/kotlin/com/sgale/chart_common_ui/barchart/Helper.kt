package com.sgale.chart_common_ui.barchart

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Canvas draw scope to draw a bar at the specified position.
 */
fun DrawScope.drawBar(
    x: Float,
    y: Float,
    height: Float
) {
    drawRect(
        color = Color.Blue,
        topLeft = Offset(0f, y),
        size = Size(x, height)
    )
}