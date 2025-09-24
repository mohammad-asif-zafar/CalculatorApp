package com.hathway.kmm_basic_app.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cal.screen.CalScreens
import com.hathway.kmm_basic_app.android.common.components.CustomButton
import com.hathway.kmm_basic_app.android.common.components.NormalTextField
import com.hathway.kmm_basic_app.android.common.theme.Dimens.PaddingMedium
import com.hathway.kmm_basic_app.android.vmdemo.DataViewModel
import com.hathway.kmm_basic_app.android.vmdemo.MainViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalScreens()
        }
    }
}

@Composable
fun DataScreen(viewModel: DataViewModel = viewModel()) {
    val text by viewModel.uiState.collectAsState()
    val state by viewModel.uiState.collectAsState()
    when {
        state.isLoading -> Text("Loading...")
        state.error != null -> Text("Error: ${state.error}")
        state.data != null -> Text("Data: ${state.data}")
    }


    Column {
        Spacer(modifier = Modifier.padding(PaddingMedium))


        Spacer(modifier = Modifier.padding(PaddingMedium))

        Button(onClick = { viewModel.loadData() }) {
            Text("Load")
        }
    }
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CounterScreen() {

    val vm: MainViewModel = viewModel()  // create ViewModel

    val count by vm.count.collectAsState()  // observe state


   // var divValue = vm.divide(2, 10)
   // println("value of divValue 1: $divValue")
    Column {
        Spacer(modifier = Modifier.padding(PaddingMedium))
//keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        NormalTextField(
            hint = stringResource(id = R.string.add),
            placeHolder = stringResource(id = R.string.add),
            keyboardType = KeyboardType.Number
        ) // textField of Full Name
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        CustomButton(
            text = stringResource(id = R.string.result), onClick = { vm.increment() })
    }

}

@Preview
@Composable
fun GreetingView() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ) {

    }
}


