package cal.di

import androidx.room.Room
import androidx.room.RoomDatabase
import cal.room.database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSHomeDirectory

actual fun platformModule(): Module = module {
    single {
        val dbFile = NSHomeDirectory() + "/calculator_db"
        Room.databaseBuilder<AppDatabase>(
            name = dbFile,
            factory = { AppDatabase::class.instantiateImpl() }
        ).build()
    }
    single { get<AppDatabase>().historyDao() }
}

// Room generator creates this
private fun AppDatabase.Companion.instantiateImpl(): AppDatabase {
    throw NotImplementedError("Room generator will override this")
}
