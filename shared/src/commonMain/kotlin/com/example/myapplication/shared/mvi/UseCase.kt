package com.example.myapplication.shared.mvi

import com.example.myapplication.shared.Video
import kotlinx.coroutines.flow.*

interface UseCase<I: MviIntent, S: MviState, E: MviEvent?> {

    fun emit(intent: I)

    //Android
    fun getUiStates(): MutableStateFlow<S>

    fun getEvents(): MutableSharedFlow<E>
}