package cal.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hathway.kmm_basic_app.android.R
import com.hathway.kmm_basic_app.android.common.theme.Dimens.FontMedium
import com.hathway.kmm_basic_app.android.common.theme.Dimens.padding48
import com.hathway.kmm_basic_app.android.common.theme.Dimens.paddingStart

@Composable
fun CalButtonLabels(text: String,
                    onClick: () -> Unit,
                    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(start = paddingStart, end = paddingStart)
            .height(padding48)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE31459),
            contentColor = Color.White
        )
    ) {
        Text(text = text, fontSize = FontMedium)
    }
}

@Preview
@Composable
private fun myCalButtonLabels() {
    CalButtonLabels( text = stringResource(id = R.string.mcontinue), onClick = {  })
}