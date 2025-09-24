package com.hathway.kmm_basic_app.android.ui.register

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hathway.kmm_basic_app.android.R
import com.hathway.kmm_basic_app.android.common.components.BackButtonAndLabel
import com.hathway.kmm_basic_app.android.common.components.CustomButton
import com.hathway.kmm_basic_app.android.common.components.NormalTextField
import com.hathway.kmm_basic_app.android.common.components.NormalTextFieldSmall
import com.hathway.kmm_basic_app.android.common.components.ScreenName
import com.hathway.kmm_basic_app.android.common.components.ScreenSubTitle
import com.hathway.kmm_basic_app.android.data.CounterViewModel
import com.hathway.kmm_basic_app.android.vmdemo.MainViewModel

@Composable
fun RegistrationScreen(onLoginClick: () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        Registration(onLoginClick)
    }
}

@Composable
fun Registration(onLoginClick: () -> Unit) {

    val viewModel = viewModel<CounterViewModel>() // Explicit type
    val vm = viewModel<MainViewModel>() // Explicit type
    val count by viewModel.count.observeAsState(0)
    val scrollState = rememberScrollState()  // Create and remember scroll state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)  // Attach the scroll state here

    ) {
        Column {
            Text(text = "Your value = $count")

            BackButtonAndLabel({}, stringResource(id = R.string.register)) // back button with title

            ScreenName(title = stringResource(id = R.string.getting_started)) // Screen Name

            ScreenSubTitle(title = stringResource(id = R.string.seems_you_are_new_here))  // Screen Subtitle

            NormalTextField(
                hint = stringResource(id = R.string.full_name),
                placeHolder = stringResource(id = R.string.full_name),
                vm.keyboardTypeFromInt(3)

            ) // textField of Full Name
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = stringResource(id = R.string.email_address),
                placeHolder = stringResource(id = R.string.email_address)
            ) // textField of Email Address
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = stringResource(id = R.string.current_address),
                placeHolder = stringResource(id = R.string.current_address)
            )//textField of Current Address
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextFieldSmall(
                hint1 = stringResource(id = R.string.zip_code),
                placeHolder1 = stringResource(id = R.string.zip_code),
                hint2 = stringResource(id = R.string.state),
                placeHolder2 = stringResource(id = R.string.state)
            ) // textField of ZIP Code and State Name
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = stringResource(id = R.string.password),
                placeHolder = stringResource(id = R.string.password)
            ) // textField of Password
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            NormalTextField(
                hint = stringResource(id = R.string.confirm_password),
                placeHolder = stringResource(id = R.string.confirm_password)
            )// textField of Confirm password
            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            CustomButton(
                text = stringResource(id = R.string.mcontinue), onClick = { viewModel.increment() })

            Spacer(modifier = Modifier.padding(bottom = 220.dp))
        }/*  androidx.compose.foundation.verticalScrollbar(
              adapter = rememberScrollbarAdapter(scrollState),
              modifier = Modifier
                  .align(Alignment.CenterEnd)
                  .fillMaxHeight()
          )*/
    }

}

@Preview
@Composable
fun RegistrationPreview(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        //Registration(onLoginClick)
    }
}