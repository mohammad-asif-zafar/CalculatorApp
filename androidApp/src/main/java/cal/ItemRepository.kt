package cal

import cal.model.Item
import kotlinx.coroutines.delay

class ItemRepository {
    private var page = 0

    // simulate network paging
    suspend fun fetchPage(pageSize: Int = 20): List<Item> {
        delay(600) // simulate network
        val start = page * pageSize
        val list = (start until start + pageSize).map {
            Item(
                id = it.toString(),
                title = "Item #$it",
                subtitle = "Subtitle $it",
                imageUrl = "https://picsum.photos/seed/$it/200/200"
            )
        }
        page++
        return list
    }

    fun resetPaging() {
        page = 0
    }
}