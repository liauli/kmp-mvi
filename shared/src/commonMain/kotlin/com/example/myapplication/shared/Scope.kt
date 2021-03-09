package com.example.myapplication.shared

import kotlinx.coroutines.CoroutineScope

expect class Scope {
    fun get(): CoroutineScope
}