package com.hathway.kmm_basic_app.android.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hathway.kmm_basic_app.android.common.theme.Dimens.paddingStart
import com.hathway.kmm_basic_app.android.vmdemo.MainViewModel


@Composable
fun NormalTextField(hint: String, placeHolder: String,  keyboardType: KeyboardType = KeyboardType.Text   ) {
    var value by remember { mutableStateOf("") }
    val vm: MainViewModel = viewModel()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),

        contentAlignment = Alignment.Center
    ) {


        Row(modifier = Modifier.padding(start = paddingStart, end = paddingStart)) {
            OutlinedTextField(
                value = value,
                onValueChange = { value = it },

                keyboardOptions = KeyboardOptions(keyboardType = keyboardType,
                    imeAction = ImeAction.Done),

                label = { Text(hint) },
                placeholder = { Text(placeHolder) }, // 👈 Placeholder

                singleLine = true,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(2.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.Gray,
                )

            )
        }
    }
}



@Composable
fun NormalTextFieldSmall(hint1: String, placeHolder1: String, hint2: String, placeHolder2: String) {
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var options: List<String> = listOf("Option 1", "Option 2", "Option 3")
    Box(
        modifier = Modifier
            .height(70.dp)
            .padding(6.dp),
    ) {

        Row(modifier = Modifier.padding(start = paddingStart, end = paddingStart)) {
            OutlinedTextField(
                value = value1,
                onValueChange = { value1 = it },
                label = { Text(hint1) },
                placeholder = { Text(placeHolder1) }, // 👈 Placeholder
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = Modifier
                    .padding(2.dp)
                    .weight(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.Gray,
                )
            )
            OutlinedTextField(
                value = value2,
                onValueChange = { value2 = it },
                label = { Text(hint2) },
                placeholder = { Text(placeHolder2) }, // 👈 Placeholder
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(2.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.Gray,
                )
            )
        }
    }
}