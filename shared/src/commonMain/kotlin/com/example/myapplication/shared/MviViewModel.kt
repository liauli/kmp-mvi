package com.example.myapplication.shared

import com.example.myapplication.shared.mvi.MviEvent
import com.example.myapplication.shared.mvi.MviIntent
import com.example.myapplication.shared.mvi.MviState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

expect class MviViewModel<I: MviIntent, S: MviState, E: MviEvent?>{

    fun emit(intent:I)

    fun getUiStates(): MutableStateFlow<S>

    fun getEventStates(): MutableSharedFlow<E>
}