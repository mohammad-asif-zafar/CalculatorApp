package cal.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cal.room.dao.HistoryDao
import cal.room.entity.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}
