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

package com.sgale.chart_core

import com.sgale.chart_core.csv.CsvParser
import com.sgale.chart_core.model.ChartDataModel
import com.sgale.chart_core.model.ChartEntryModel

abstract class AbstractChart <T>(
    private val data: String,
    private val parse: (String) -> ChartDataModel<T>
) : ChartEntry where T : Number, T : Comparable<T> {

    private val csvParser = CsvParser()

    val chartData: ChartDataModel<T> by lazy {
        val raw = parse(data)
        ChartDataModel(
            values = raw.values.sortedByDescending { it.currentValue }
        )
    }
}
