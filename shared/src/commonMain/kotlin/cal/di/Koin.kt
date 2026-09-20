package cal.di

import cal.repo.HistoryRepository
import cal.viewmodel.CalculationRepo
import cal.viewmodel.CalculatorViewModel
import cal.viewmodel.HistoryViewModel
import cal.viewmodel.ItemsViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val sharedModule = module {
    single { CalculationRepo() }
    single { HistoryRepository(get()) }
    
    factory { CalculatorViewModel() }
    factory { HistoryViewModel(get()) }
    factory { ItemsViewModel(get(), get()) }
}

expect fun platformModule(): Module
