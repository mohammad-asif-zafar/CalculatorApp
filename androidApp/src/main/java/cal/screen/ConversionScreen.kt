package cal.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cal.constants.CurrencyCode
import cal.viewmodel.CurrencyViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionScreen(
    viewModel: CurrencyViewModel = koinViewModel(),      // or pass via parameters
    onCurrencySelected: (CurrencyCode) -> Unit = {}
) {
    val query by viewModel.query.collectAsState()
    val list by viewModel.filtered.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        // Search field
        OutlinedTextField(
            value = query,
            onValueChange = { viewModel.setQuery(it) },
            placeholder = { Text("Search by code, name or symbol") },
            singleLine = true,
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(onClick = { viewModel.clearQuery() }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        )

        // Optional: show count / clear all
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Results: ${list.size}", style = MaterialTheme.typography.bodySmall)
            TextButton(onClick = { viewModel.refresh() }) {
                Text("Refresh")
            }
        }

        // Results
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(list) { currency ->
                CurrencyRow(currency = currency, onClick = { onCurrencySelected(currency) })
            }
        }
    }
}

@Composable
fun CurrencyRow(currency: CurrencyCode, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "${currency.code}  ${currency.symbol}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(text = currency.fullName, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
