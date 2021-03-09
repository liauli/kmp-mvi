package com.example.myapplication.shared

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

actual class Scope {
    actual fun get(): CoroutineScope{
        return MainScope()
    }
}