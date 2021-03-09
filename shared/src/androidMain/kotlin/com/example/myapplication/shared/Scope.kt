package com.example.myapplication.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual class Scope: ViewModel() {
    actual fun get(): CoroutineScope{
        return viewModelScope
    }
}