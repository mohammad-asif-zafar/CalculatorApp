package cal.di

import cal.repo.HistoryRepository
import cal.viewmodel.CalculationRepo
import org.koin.dsl.module

val appModule = module {
    single { CalculationRepo() }          // your repo
    single { HistoryRepository(get()) }        // shared history repository
    single { HistoryRepository(get()) }   // provide repo with dao


}