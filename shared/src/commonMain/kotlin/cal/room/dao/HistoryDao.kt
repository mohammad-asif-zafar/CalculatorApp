package cal.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cal.room.entity.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(item: HistoryEntity)

    @Query("SELECT * FROM history ORDER BY id DESC")
    fun getAllHistory(): Flow<List<HistoryEntity>>

    @Query("DELETE FROM history")
    suspend fun clear()
}
