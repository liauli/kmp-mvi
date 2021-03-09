package com.liauli.kmp.shared.mvi

import kotlinx.coroutines.flow.*

interface UseCase<I: MviIntent, S: MviState, E: MviEvent?> {

    fun emit(intent: I)

    //Android
    fun getUiStates(): MutableStateFlow<S>

    fun getEvents(): MutableSharedFlow<E>
}