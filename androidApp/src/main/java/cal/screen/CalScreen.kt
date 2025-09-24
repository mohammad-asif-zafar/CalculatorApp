package cal.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.lifecycle.viewmodel.compose.viewModel
import cal.ItemsViewModel
import cal.SimpleLazyColumn
import cal.components.CustomTextField
import cal.components.LocalImageExample
import com.hathway.kmm_basic_app.android.R


@Composable
fun CalScreens(modifier: Modifier = Modifier) {

    val viewModel = viewModel<ItemsViewModel>() // Explicit type
    val res by viewModel.result.collectAsState()

    Surface(
        color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1.3f)
            ) {
                val (topBox, iconRef) = createRefs()

                Box(modifier = Modifier
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
                        onClick = { },
                        imageVector = Icons.Filled.Settings,
                        contentDescription = stringResource(id = R.string.back),
                        tintColor = Color.Gray,
                        size = 24.dp,
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(3.6f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,

                ) {//2nd box
                CustomTextField(
                    text = res.toString(),
                    label = stringResource(id = R.string.empty_item),
                    modifier = modifier.fillMaxSize(),

                    )
            }

            Box(
                modifier = Modifier
                    .weight(5.1f)
                    .padding(top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                SimpleLazyColumn(items = viewModel.itemData(), onClick = { clicked ->
                    // println("IND-1A: $clicked")
                    viewModel.buttonClickItem(clicked)

                })
            }

            println("value $res")
            Text(text = res.toString())

        }


    }

}

@Preview
@Composable
private fun myD() {
    CalScreens()
}

