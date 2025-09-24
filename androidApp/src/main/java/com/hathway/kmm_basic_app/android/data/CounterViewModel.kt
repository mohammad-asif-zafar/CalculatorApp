package com.hathway.kmm_basic_app.android.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    // LiveData to hold the counter value
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun increment() {
        _count.value = (_count.value ?: 0) + 1
    }

}
