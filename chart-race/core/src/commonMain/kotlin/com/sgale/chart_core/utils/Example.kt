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

package com.sgale.chart_core.utils

import com.sgale.chart_core.ChartData
import com.sgale.chart_core.model.ChartItem
import com.sgale.chart_core.model.ChartLabel

object Example {
    val exampleData = ChartData(
        data = List(10) { index ->
            ChartItem(
                label = ChartLabel(
                    id = index.toString(),
                    name = randomStringGenerator(),
                )
            )
        }
    )
}

private fun randomStringGenerator(maxLength: Int = 10): String {
    val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    return (1..maxLength)
        .map { chars.random() }
        .joinToString("")
}