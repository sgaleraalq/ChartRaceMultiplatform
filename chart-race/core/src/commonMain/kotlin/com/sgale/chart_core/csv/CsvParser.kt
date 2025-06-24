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

import com.sgale.chart_core.barchart.ChartEntryModel
import com.sgale.chart_core.utils.ChartRaceLog.Companion.log
import org.koin.core.context.KoinContext

class CsvParser(
    private val csv: String,
    private val values: List<String>,
    private val delimiter: String = ","
) {
//    private fun readCsvFromUri(context: KoinContext): String? {
//        return context.contentResolver.openInputStream(uri)?.bufferedReader()?.use { it.readText() }
//    }

    fun parse(): List<ChartEntryModel> {
//        val openCsv = readCsvFromUri(csv)
        val lines = csv.trim().lines().filter { it.isNotBlank() }

        log.i { "Parsing CSV with ${lines.size} lines and delimiter '$delimiter'" }
        return listOf(ChartEntryModel())
    }

}