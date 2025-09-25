package cal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Read-only display that visually matches the previous CustomTextField design.
 *
 * @param text The text to display inside the box.
 * @param label Optional small label shown above the box (like TextField's label).
 * @param modifier Modifier to pass from caller.
 * @param contentPadding Inner padding for the content area.
 */
@Composable
fun CustomTextDisplay(
    textSmall: String,
    textLarge: String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 10.dp)
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Box-like surface to mimic OutlinedTextField appearance
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp)                    // 👈 OUTER padding (outside the b
                .clip(RoundedCornerShape(20.dp))
                .border(width = 1.dp, color = Color(0xFFE3E3E3), shape = RoundedCornerShape(20.dp))
                .background(color = Color.Transparent), // keep same container color behavior
            // .padding(vertical = 60.dp), // 👈 INNER padding (inside the border, around text)
            color = Color.Transparent, shadowElevation = 0.dp
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                // Top text
                Text(
                    text = textSmall,
                    fontSize = 25.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF767676),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.End) // use CenterHorizontally if you want centered

                )
                // Bottom text (dark & big)
                Text(
                    text = textLarge,
                    fontSize = 55.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF6F6F6F),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .align(Alignment.End) // use CenterHorizontally if you want centered
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewCustomTextDisplay() {
    CustomTextDisplay(
        textSmall = "textSmall", textLarge = "textLarge", modifier = Modifier.fillMaxSize()
    )
}