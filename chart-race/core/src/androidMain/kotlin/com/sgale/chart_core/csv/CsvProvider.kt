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

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri

class CsvProvider(
    private val context: Context
) : ICsvProvider {

    private fun assetExists(assetName: String): Boolean = try {
        context.assets.open(assetName).close()
        true
    } catch (e: Exception) {
        false
    }

    override fun readCsvFromUri(csvPath: String): String? {
        return try {
            if (csvPath.startsWith("assets/")) {
                val assetName = csvPath.removePrefix("assets/")
                if (!assetExists(assetName)) return "Couldn't find CSV file at $csvPath"
                context.assets.open(assetName).bufferedReader().use { it.readText() }
            } else {
                val uri = csvPath.toUri()
                context.contentResolver.openInputStream(uri)?.bufferedReader()?.use { it.readText() }
                    ?: "Couldn't open CSV file at $csvPath"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Error reading CSV file at $csvPath: ${e.message}"
        }
    }
}