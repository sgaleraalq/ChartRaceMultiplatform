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

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ChartBackground(
    modifier: Modifier = Modifier,
    height: Dp = 300.dp,
    rows: Int = 5
) {
    Canvas(modifier = modifier.height(height)) {
        drawFrame()
    }
}

@Composable
fun ChartRow(
    modifier: Modifier
) {
    Box(
        modifier = modifier.padding(vertical = 4.dp).background(color = Yellow)
    )
}

@Composable
fun BarChartRace(
    csvData: String
) {
    println("BarChartRace: $csvData")
}