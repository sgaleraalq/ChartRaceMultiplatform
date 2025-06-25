package com.sgale.chart_race

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sgale.chart_core.csv.CsvProviderImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this.applicationContext
        val myCsvProvider = CsvProviderImpl(context)

        setContent {
            App(csvProvider = myCsvProvider)
        }


    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}