package com.hathway.kmm_basic_app.android.vmdemo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {

    private val _count = MutableStateFlow(0) // private mutable
    val count: StateFlow<Int> = _count.asStateFlow() // public read-only

    fun increment() {
        _count.value += 1
    }
    fun buttonClickItem(){

    }



    fun keyboardTypeFromInt(value: Int): KeyboardType {
        return when (value) {
            1 -> KeyboardType.Text
            2 -> KeyboardType.Ascii
            3 -> KeyboardType.Number
            4 -> KeyboardType.Phone
            5 -> KeyboardType.Uri
            6 -> KeyboardType.Email
            7 -> KeyboardType.Password
            8 -> KeyboardType.NumberPassword
            else -> KeyboardType.Text
        }
    }

}
