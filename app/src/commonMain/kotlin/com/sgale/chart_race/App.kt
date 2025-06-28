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

package com.sgale.chart_race

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.sgale.chart_common_ui.ChartRace
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(csvData: String?) {
    MaterialTheme {
        SampleScreen(csvData)
    }
}


@Composable
fun SampleScreen(
    csvData: String?
) {
    if (csvData.isNullOrBlank()) return

    val softDark = Color(0xFF121212)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(softDark)
            .systemBarsPadding()

    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = "This is sample screen",
            color = White
        )
        Spacer(Modifier.height(12.dp))
        ChartRace(csvData)
    }
}
