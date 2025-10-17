package cal.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hathway.kmm_basic_app.android.R


@Composable
fun LocalImageExample(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Icons.Default.Refresh,
    contentDescription: String,
    tintColor: Color,
    size: Dp
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription.toString(),
        modifier = modifier
            .padding(8.dp)
            .height(size)
            .width(size)
            .clickable { onClick() },
        tint = tintColor
    )
}

@Preview
@Composable
private fun PreviewLocalImageExample() {
    LocalImageExample(
        onClick = { },
        imageVector = Icons.Default.Refresh,
        contentDescription = stringResource(id = R.string.back),
        tintColor = Color.Yellow,
        size = 48.dp
    )

}