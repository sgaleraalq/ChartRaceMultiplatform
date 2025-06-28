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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import chartracemultiplatform.chart_race.chart_common_ui.generated.resources.Res
import chartracemultiplatform.chart_race.chart_common_ui.generated.resources.ic_pause_button
import chartracemultiplatform.chart_race.chart_common_ui.generated.resources.ic_play_button
import org.jetbrains.compose.resources.painterResource

@Composable
fun PlayButton(
    isPlaying: Boolean,
    onTimeStarted: () -> Unit,
    onTimePaused: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxHeight().padding(horizontal = 8.dp)
    ) {
        Surface(
            modifier = Modifier.size(32.dp),
            shape = CircleShape,
            tonalElevation = 4.dp,
            shadowElevation = 4.dp,
            color = White
        ) {
            IconButton(
                onClick = {
                    if (isPlaying) {
                        onTimePaused()
                    } else {
                        onTimeStarted()
                    }
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Transparent
                )
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = if (isPlaying) {
                        painterResource(Res.drawable.ic_pause_button)
                    } else {
                        painterResource(Res.drawable.ic_play_button)
                    },
                    contentDescription = "Start or Pause Timer",
                    tint = Unspecified
                )
            }
        }
    }
}
