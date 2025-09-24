package cal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SimpleLazyColumn(onClick: (String) -> Unit, items:List<String>) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(4), // 4 columns
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 20.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clickable { onClick(item) } // ✅ fixed

            ) {
                Text(
                    text = item,
                    color = Color(0xFF262626),
                    modifier = Modifier
                        .fillMaxWidth()   // take full width so centering works
                        .padding(12.dp),
                    textAlign = TextAlign.Center // center text inside that width
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSimpleLazyColumn() {
   // SimpleLazyColumn()
}