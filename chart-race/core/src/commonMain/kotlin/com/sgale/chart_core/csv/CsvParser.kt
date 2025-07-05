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

package com.sgale.chart_core.csv

import com.sgale.chart_core.model.ChartDataModel
import com.sgale.chart_core.model.ChartEntryModel

class CsvParser(
    private val delimiter: String = ","
) : ICsvParser {
    private val headerMap = mutableMapOf<Int, String>()

    private fun populateHeaderMap(headerLine: String) {
        headerLine.split(delimiter).forEachIndexed { index, header ->
            headerMap[index] = header.trim()
        }
    }

    private inline fun <reified T : Number> parseCsv(csvData: String): ChartDataModel<T> {
        val lines = csvData.trim().lines()
        if (lines.size < 2) return ChartDataModel(emptyList())

        populateHeaderMap(lines[0])

        val entries = lines.drop(1).mapNotNull { line ->
            val values = line.split(delimiter)

            val valuesMap = values.mapIndexedNotNull { index, value ->
                val key = headerMap[index] ?: return@mapIndexedNotNull null
                val parsed = parseValue<T>(value)
                parsed?.let { key to it }
            }.toMap()

            if (valuesMap.isEmpty()) return@mapNotNull null

            val label = values.getOrNull(0)?.trim() ?: return@mapNotNull null

            ChartEntryModel(
                id = label, // todo
                label = label,
                currentPercentage = 1f,
                values = valuesMap
            )
        }

        return ChartDataModel(entries)
    }

    private inline fun <reified T : Number> parseValue(raw: String): T? =
        when (T::class) {
            Int::class -> raw.toIntOrNull() as? T
            Long::class -> raw.toLongOrNull() as? T
            Double::class -> raw.toDoubleOrNull() as? T
            else -> null
        }

    override fun parseCsvAsInt(csvData: String): ChartDataModel<Int> = parseCsv(csvData)
    override fun parseCsvAsDouble(csvData: String): ChartDataModel<Double> = parseCsv(csvData)
    override fun parseCsvAsLong(csvData: String): ChartDataModel<Long> = parseCsv(csvData)
}