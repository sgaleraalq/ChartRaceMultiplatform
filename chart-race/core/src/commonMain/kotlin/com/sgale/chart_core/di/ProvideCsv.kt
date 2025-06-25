package com.sgale.chart_core.di

import com.sgale.chart_core.csv.ICsvProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ProvideCsv {
    val csvModule = module {
//        singleOf(::CsvProviderImpl) { bind<ICsvProvider>() }
    }
}