package cal.di

import cal.repo.CurrencyRepository
import cal.repo.DefaultCurrencyRepository
import org.koin.dsl.module


val dataModule = module {
    single<CurrencyRepository> { DefaultCurrencyRepository() } // provide repo
}


