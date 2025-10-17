package cal.di

import androidx.room.Room
import cal.repo.HistoryRepository
import cal.room.database.AppDatabase
import cal.viewmodel.CalculationRepo
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "calculator_db"
        ).build()
    }
    single { get<AppDatabase>().historyDao() }
    single { HistoryRepository(get()) }
    single { CalculationRepo() }
}
