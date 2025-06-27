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

package com.sgale.chart_common_ui.desingsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TimeBar(
    isPlaying: Boolean = false,
    onTimeStarted: () -> Unit,
    onTimePaused: () -> Unit,
) {

    Box(
        modifier = Modifier.fillMaxWidth().background(White),
        contentAlignment = Center
    ) {
        Row(
            verticalAlignment = CenterVertically
        ) {
            IconButton(
                modifier = Modifier.background(Red),
                onClick = {
                    if (!isPlaying) {
                        onTimeStarted()
                    } else {
                        onTimePaused()
                    }
                },
            ) {
                // todo
            }
            Spacer(Modifier.width(12.dp))
            Box(
                modifier = Modifier.weight(1f).height(1.dp).background(Gray)
            )
            Spacer(Modifier.width(12.dp))
        }
    }
}

@Composable
@Preview
fun PreviewTimeBar() {
    TimeBar(
        onTimeStarted = {},
        onTimePaused = {}
    )
}