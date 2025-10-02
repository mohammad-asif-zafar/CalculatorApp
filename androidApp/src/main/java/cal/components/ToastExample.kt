package cal.components

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ToastExample() {
    val context = LocalContext.current

    Button(onClick = {
        Toast.makeText(context, "Hello from Compose!", Toast.LENGTH_SHORT).show()
    }) {
        Text("Show Toast")
    }
}