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
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.drawTriangle(
    arrowHeight: Dp,
    color: Color = Gray
) {
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val width = arrowHeight.toPx()
        val height = arrowHeight.toPx()

        val path = Path().apply {
            moveTo(width / 2f, height)
            lineTo(0f, 0f)
            lineTo(width, 0f)
            close()
        }

        drawPath(path = path, color = color)
    }
}
