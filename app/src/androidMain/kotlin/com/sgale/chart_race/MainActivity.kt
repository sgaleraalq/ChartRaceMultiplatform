package com.sgale.chart_race

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sgale.chart_race.utils.CsvOpener

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val csvOpener = CsvOpener(this, "sample.csv")

        setContent {
            App(csvOpener.openCsv())
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App("")
}