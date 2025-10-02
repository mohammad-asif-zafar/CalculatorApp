package cal.lazy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cal.keybroad.ClearItem
import cal.keybroad.DefaultItem
import cal.keybroad.DigitItem
import cal.keybroad.EqualsItem
import cal.keybroad.OperatorItem
import cal.keybroad.ViewItems
import cal.model.CalculatorKey
import cal.model.CalculatorKeysList
import cal.model.KeyType


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleLazyColumn(
    items: List<CalculatorKey>, onKeyClick: (CalculatorKey) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(4),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items, key = { it.id }) { key ->
            when (key.type) {
                KeyType.DIGIT -> DigitItem(key) { onKeyClick(key) }
                KeyType.OPERATOR -> OperatorItem(key) { onKeyClick(key) }
                KeyType.CLEAR -> ClearItem(key) { onKeyClick(key) }
                KeyType.EQUALS -> EqualsItem(key) { onKeyClick(key) }
                KeyType.SPECIAL_MODE -> ViewItems(key = key, onClick = { onKeyClick(key) })
                KeyType.CLEAR_ITEM -> ViewItems(
                    key = key, onClick = { onKeyClick(key) }, imageVector = Icons.Default.Backspace
                )

                else -> DefaultItem(key) { onKeyClick(key) }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSimpleLazyColumn() {
    SimpleLazyColumn(
        items = CalculatorKeysList.keys, onKeyClick = { item ->
        })
}