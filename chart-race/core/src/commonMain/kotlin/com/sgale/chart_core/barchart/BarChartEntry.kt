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

package com.sgale.chart_core.barchart

import com.sgale.chart_core.AbstractChartEntry
import com.sgale.chart_core.model.ChartEntryModel
import kotlinx.coroutines.flow.MutableStateFlow

class BarChartEntry <T: Number> (
    entryModel: ChartEntryModel<T>
) : AbstractChartEntry() {

    override val id = entryModel.id
    override val label = entryModel.label

    private val _currentValue = MutableStateFlow(entryModel.currentValue)
    val currentValue = _currentValue

    override fun updateCurrentValue(time: Float) {
        _currentValue.value = time
    }
}
