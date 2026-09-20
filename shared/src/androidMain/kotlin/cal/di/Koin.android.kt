package cal.di

import androidx.room.Room
import cal.room.database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import android.content.Context

actual fun platformModule(): Module = module {
    single {
        val context = get<Context>()
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "calculator_db"
        ).build()
    }
    single { get<AppDatabase>().historyDao() }
}
