package cal.di


import cal.viewmodel.CalculatorViewModel
import cal.viewmodel.CurrencyViewModel
import cal.viewmodel.HistoryViewModel
import cal.viewmodel.ItemsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CalculatorViewModel() }
    viewModel { HistoryViewModel(get()) }
    viewModel { ItemsViewModel(get(), get()) }
    viewModel { CurrencyViewModel(get()) } // inject CurrencyRepository

}