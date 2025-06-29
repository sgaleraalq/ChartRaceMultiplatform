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

class Timer(
    timelineItems: Int
) {
    companion object {
        const val DELAY_TIME = 16L
        const val TIMELINE_INTERVAL = 1000L
    }

    private val maxTime: Long = TIMELINE_INTERVAL * timelineItems

    private var startTimeMillis: Long = 0L
    private var accumulatedTime: Long = 0L
    private var elapsedTime:     Long = 0L
    private var job: Job? = null
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    /**
     * Composable state flow to hold the elapsed time in milliseconds.
     */
    private val _timePercentage = MutableStateFlow(0f)
    var timePercentage: StateFlow<Float> = _timePercentage
    private val _isPlaying = MutableStateFlow(false)
    var isPlaying: StateFlow<Boolean> = _isPlaying

    fun startTime() {
        _isPlaying.value = true
        if (job == null) {
            startTimeMillis = currentTimeMillis()
            job = coroutineScope.launch {
                while (isActive && elapsedTime <= maxTime) {
                    delay(DELAY_TIME)
                    elapsedTime = accumulatedTime + (currentTimeMillis() - startTimeMillis)
                    _timePercentage.value = (elapsedTime.toFloat() / maxTime.toFloat()).coerceIn(0f, 1f)
                    if (elapsedTime > maxTime) {
                        reset()
                    }
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
        elapsedTime = accumulatedTime
    }

    fun onTimePositionChanged(position: Float) {
        job?.cancel()
        job = null
        _isPlaying.value = false
        elapsedTime = (maxTime * position).toLong()
        accumulatedTime = elapsedTime
        startTimeMillis = currentTimeMillis()
        _timePercentage.value = position.coerceIn(0f, 1f)
    }

    private fun reset() {
        job?.cancel()
        job = null
        elapsedTime = 0L
        accumulatedTime = 0L
        startTimeMillis = 0L
        _timePercentage.value = 0f
        _isPlaying.value = false
    }

    @OptIn(ExperimentalTime::class)
    private fun currentTimeMillis(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }
}
