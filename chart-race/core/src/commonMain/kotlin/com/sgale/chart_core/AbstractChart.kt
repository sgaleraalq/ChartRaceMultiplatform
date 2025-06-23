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

abstract class AbstractChart {
    abstract val height: Float

    companion object {
        const val DEFAULT_HEIGHT = 300f
        const val TIME_BETWEEN_FRAMES =  1000L
    }

    val frameTime: Long = 16L // 60 FPS


    init {

    }

    abstract fun drawFrame()

//    abstract fun drawData(data: ChartData)
//
//    abstract fun drawRow(row: Int, data: ChartData)
//
//    abstract fun drawAxisLabels(data: ChartData)
//
//    abstract fun drawLegend(data: ChartData)
}