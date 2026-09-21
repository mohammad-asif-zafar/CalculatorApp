package cal.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cal.viewmodel.ItemsViewModel
import org.koin.compose.viewmodel.koinViewModel
import cal.lazy.SimpleLazyColumn
import cal.components.CustomTextDisplay
import cal.components.LocalImageExample
import cal.model.CalculatorKeysList


@Composable
fun CalculatorScreen(onOpenHistory: () -> Unit) {

    val viewModel = koinViewModel<ItemsViewModel>()
    val smallRes by viewModel.smallRes.collectAsState()
    val largeRes by viewModel.largeRes.collectAsState()

    Surface(
        color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.3f)
                    .background(Color(0xFFFFFFFF)),
                contentAlignment = Alignment.TopEnd
            ) {
                Box(modifier = Modifier
                    .background(Color(0xFFFFFFFF))
                    .size(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LocalImageExample(
                        onClick = { onOpenHistory() },
                        imageVector = Icons.Filled.HistoryEdu,
                        contentDescription = "History",
                        tintColor = Color.Gray,
                        size = 24.dp,
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(3f)
                    .background(Color(0xFFFFFFFF))
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,

                ) {
                CustomTextDisplay(
                    textSmall = smallRes.toString(), textLarge = largeRes.toString()
                )

            }

            Box(
                modifier = Modifier
                    .weight(6f)
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                SimpleLazyColumn(
                    items = CalculatorKeysList.keys, onKeyClick = { item ->
                        viewModel.buttonClickItem(item.label)
                    })
            }

        }
    }
}
