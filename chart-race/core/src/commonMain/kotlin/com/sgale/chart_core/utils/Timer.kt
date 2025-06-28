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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

object Timer {
    private const val DELAY_TIME: Long = 16L
    private var startTimeMillis: Long = 0L
    private var accumulatedTime: Long = 0L
    private var job: Job? = null
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    /**
     * Composable state flow to hold the elapsed time in milliseconds.
     */
    private val _elapsedTime = MutableStateFlow(0L)
    val elapsedTime: StateFlow<Long> = _elapsedTime
    private val _isPlaying = MutableStateFlow(false)
    var isPlaying: StateFlow<Boolean> = _isPlaying

    fun startTime() {
        _isPlaying.value = true
        if (job == null) {
            startTimeMillis = currentTimeMillis()
            job = coroutineScope.launch {
                while (isActive) {
                    delay(DELAY_TIME)
                    _elapsedTime.value = accumulatedTime + (currentTimeMillis() - startTimeMillis)
                }
            }
        }
    }

    fun pauseTime() {
        _isPlaying.value = false
        job?.cancel()
        job = null
        val now = currentTimeMillis()
        accumulatedTime += now - startTimeMillis
        _elapsedTime.value = accumulatedTime
    }

    fun stopTime() {
        job?.cancel()
        job = null
        _elapsedTime.value = 0L
    }

    @OptIn(ExperimentalTime::class)
    private fun currentTimeMillis(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }
}
