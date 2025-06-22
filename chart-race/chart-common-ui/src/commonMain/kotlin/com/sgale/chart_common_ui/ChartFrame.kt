package com.sgale.chart_common_ui

import androidx.compose.ui.geometry.Offset.Companion.Zero
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

fun DrawScope.drawFrame(color: Color = Color(0xFFEEEEEE)) {
    return drawRect(
        color = color,
        topLeft = Zero,
        size = size
    )
}