package cal.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import cal.components.CustomTextDisplay
import cal.components.LocalImageExample
import cal.lazy.SimpleLazyColumn
import cal.model.CalculatorKeysList
import cal.viewmodel.ItemsViewModel
import com.hathway.kmm_basic_app.android.R
import org.koin.androidx.compose.getViewModel


@Composable
fun CalculatorScreen(onOpenHistory: () -> Unit) {

    val viewModel = getViewModel<ItemsViewModel>()
    val smallRes by viewModel.smallRes.collectAsState()
    val largeRes by viewModel.largeRes.collectAsState()




    Surface(
        color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(.8f)
                    .background(Color(0xFFFFFFFF))
            ) {
                val (topBox, iconRef) = createRefs()

                Box(modifier = Modifier
                    .background(Color(0xFFFFFFFF))
                    .constrainAs(topBox) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        // give the box a fixed height or a percent less than 1f
                        height = Dimension.value(50.dp)
                        width = Dimension.value(50.dp)
                    }
                    .fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                    LocalImageExample(
                        onClick = { onOpenHistory() },
                        imageVector = Icons.Filled.HistoryEdu,
                        contentDescription = stringResource(id = R.string.history),
                        tintColor = Color.Gray,
                        size = 24.dp,
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(2.5f)
                    .background(Color(0xFFFFFFFF))
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,

                ) {//2nd box
                CustomTextDisplay(
                    textSmall = smallRes.toString(), textLarge = largeRes.toString()
                )

            }

            Box(
                modifier = Modifier
                    .weight(7f)
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                SimpleLazyColumn(
                    items = CalculatorKeysList.keys, onKeyClick = { item ->
                        viewModel.buttonClickItem(item)
                    })
            }

        }


    }


}

@Preview
@Composable
private fun PreviewCalScreens() {
    CustomTextDisplay(
        textSmall = "1223", textLarge = "12331"
    )

}

