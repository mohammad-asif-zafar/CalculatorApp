package cal.repo

import cal.room.dao.HistoryDao
import cal.room.entity.HistoryEntity

class HistoryRepository(private val dao: HistoryDao) {
    val history = dao.getAllHistory()

    suspend fun add(expression: String, result: String) {
        dao.insert(HistoryEntity(expression = expression, result = result))
    }

    suspend fun clear() {
        dao.clear()
    }
}
