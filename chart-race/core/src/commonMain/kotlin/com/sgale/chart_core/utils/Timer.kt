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

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class Timer {
    private var startTimeMillis: Long = 0L
    private var elapsedTime: Long = 0L
    private var job: Job? = null
    private val delayTime: Long = 16L

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun startTime() {
        if (job == null) {
            startTimeMillis = currentTimeMillis()
            job = coroutineScope.launch {
                while (isActive) {
                    delay(delayTime)
                    elapsedTime = currentTimeMillis() - startTimeMillis
                    println("Elapsed time: $elapsedTime ms") // Debugging output
                }
            }
        }
    }

    fun pauseTime() {
        job?.cancel()
        job = null
        elapsedTime = currentTimeMillis() - startTimeMillis
    }

    fun stopTime() {
        job?.cancel()
        job = null
        elapsedTime = 0L
    }

    fun getElapsedTime(): Long = elapsedTime

    @OptIn(ExperimentalTime::class)
    private fun currentTimeMillis(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }
}