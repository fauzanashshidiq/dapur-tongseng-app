package com.example.dapurtongseng

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _fullName = MutableLiveData<String>()
    val fullName: LiveData<String> get() = _fullName

    fun setFullName(name: String) {
        _fullName.value = name
    }
}
