package cal.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hathway.kmm_basic_app.android.R

@Composable
fun CustomTextField(text: String, label: String, modifier :Modifier) {

    println("value $text")
    OutlinedTextField(
        value = text,
        onValueChange = { text },
        label = { Text(label) },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Red

        ),
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp), // custom font size
        modifier = modifier
            .padding(5.dp)
            .border(
                width = 1.dp,
                color = Color.Yellow,
                shape = RoundedCornerShape(20.dp) // rounded border
            )
            .padding(horizontal = 8.dp, vertical = 12.dp) // padding inside box,
    )
}

@Preview
@Composable
private fun PreviewCustomTextField() {
   /* CustomTextField(
        text = stringResource(id = com.hathway.kmm_basic_app.android.R.string.back),
        label = stringResource(id = R.string.back),
    )*/

}