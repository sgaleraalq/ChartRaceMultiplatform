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

import com.diamondedge.logging.Logger
import com.diamondedge.logging.logging

class ChartRaceLog : Logger {

    companion object {
        const val TAG = "ChartCore"
        val log = logging(TAG)
    }

    override fun verbose(tag: String, msg: String) { }

    override fun debug(tag: String, msg: String) { }

    override fun info(tag: String, msg: String) { }

    override fun warn(tag: String, msg: String, t: Throwable?) { }

    override fun error(tag: String, msg: String, t: Throwable?) { }

    override fun isLoggingVerbose(): Boolean = false

    override fun isLoggingDebug(): Boolean = false

    override fun isLoggingInfo(): Boolean = true

    override fun isLoggingWarning(): Boolean = true

    override fun isLoggingError(): Boolean = true
}