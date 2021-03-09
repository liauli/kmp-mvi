package com.example.myapplication.shared

import com.example.myapplication.shared.mvi.MviEvent
import com.example.myapplication.shared.mvi.MviIntent
import com.example.myapplication.shared.mvi.MviState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

actual class MviViewModel<I: MviIntent, S: MviState, E: MviEvent?> {
    actual fun emit(intent: I) {

    }

    actual fun getUiStates(): MutableStateFlow<S> {
        TODO("Not yet implemented")
    }

    actual fun getEventStates(): MutableSharedFlow<E> {
        TODO("Not yet implemented")
    }


}