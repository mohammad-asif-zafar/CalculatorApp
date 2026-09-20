package com.hathway.kmm_basic_app.ui.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hathway.kmm_basic_app.common.components.BackButtonAndLabel
import com.hathway.kmm_basic_app.common.components.CustomButton
import com.hathway.kmm_basic_app.common.components.NormalTextField
import com.hathway.kmm_basic_app.common.components.NormalTextFieldSmall
import com.hathway.kmm_basic_app.common.components.ScreenName
import com.hathway.kmm_basic_app.common.components.ScreenSubTitle
import com.hathway.kmm_basic_app.data.CounterViewModel
import com.hathway.kmm_basic_app.vmdemo.MainViewModel

@Composable
fun RegistrationScreen(onLoginClick: () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        Registration(onLoginClick)
    }
}

@Composable
fun Registration(onLoginClick: () -> Unit) {

    val counterViewModel = viewModel<CounterViewModel>()
    val mainViewModel = viewModel<MainViewModel>()
    val count by counterViewModel.count.collectAsState()
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)

    ) {
        Column {
            Text(text = "Your value = $count")

            BackButtonAndLabel({}, "Register")

            ScreenName(title = "Getting Started")

            ScreenSubTitle(title = "Seems you are new here")

            NormalTextField(
                hint = "Full Name",
                placeHolder = "Full Name",
                mainViewModel.keyboardTypeFromInt(3)
            )
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = "Email Address",
                placeHolder = "Email Address"
            )
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = "Current Address",
                placeHolder = "Current Address"
            )
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextFieldSmall(
                hint1 = "Zip Code",
                placeHolder1 = "Zip Code",
                hint2 = "State",
                placeHolder2 = "State"
            )
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = "Password",
                placeHolder = "Password"
            )
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = "Confirm Password",
                placeHolder = "Confirm Password"
            )
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            CustomButton(
                text = "Continue", onClick = { counterViewModel.increment() })

            Spacer(modifier = Modifier.padding(bottom = 220.dp))
        }
    }
}
