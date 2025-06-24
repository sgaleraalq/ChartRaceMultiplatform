package com.sgale.chart_race

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.sgale.chart_common_ui.ChartBackground
import com.sgale.chart_core.csv.CsvParser
import com.sgale.chart_core.utils.ChartRaceLog.Companion.log
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val csv = "assets/sample.csv"
    val values = listOf(
        "1960", "1961", "1962"
    )
    MaterialTheme {
        SampleScreen(csv, values)
    }
}


@Composable
fun SampleScreen(
    csv: String,
    values: List<String>
) {
    val softDark = Color(0xFF121212)

    val entries = remember(csv) {
        CsvParser(csv, values).parse()
    }

    log.i { "Procesando $entries entradas" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(softDark)
            .padding(vertical = 12.dp)
            .systemBarsPadding()

    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = "This is sample screen",
            color = White
        )
        Spacer(Modifier.height(12.dp))
        ChartBackground(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)
        )
    }
}
