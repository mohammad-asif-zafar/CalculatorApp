package com.hathway.kmm_basic_app.android.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BasicColumn() {
  /*  Column(
        modifier = Modifier
            .fillMaxSize()


          // .padding(50.dp)//  padding(a) Padding a inside
           .padding(100.dp) // Outer padding  padding(b)  Padding b outside
            .background(Color.Gray) // Gray box
    ) {
        Text("Nested Padding sdfs d qwef ds acsd f", color = Color.White)
    }*/
    /*Column(modifier = Modifier

        .fillMaxSize()

        .verticalScroll(rememberScrollState())
        .padding(1.dp)
        .padding(100.dp)



        ) {
        Text("First")
        Text("Second")
        Text("Third")
        Text("First")
        Text("Second")
        Text("Third")
        Text("First")
        Text("Second")
        Text("Third")
        Text("First")
        Text("Second")
        Text("Third")
        Text("First")
        Text("Second")
        Text("Third")
        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("First")
        Text("Second")
        Text("Third")

        Text("asif")
        Text("zafar")
        Text("muskan")



    }*/

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center).background(Color.Yellow)
        ) {
            Text("Item 1")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
            Text("Item 1")
            Text("Item 2")
            Text("Item 2")
            Text("Item 2")
        }
    }
}