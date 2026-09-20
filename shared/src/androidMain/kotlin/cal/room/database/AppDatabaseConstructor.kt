package cal.room.database

import androidx.room.RoomDatabaseConstructor

actual object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase = RoomGeneratedAppDatabaseConstructor.initialize()
}
