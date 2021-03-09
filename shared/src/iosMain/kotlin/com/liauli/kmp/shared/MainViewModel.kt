package com.liauli.kmp.shared

import com.liauli.kmp.shared.domain.FetchVideo
import kotlinx.coroutines.*


@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel(private val fetchVideo: FetchVideo) {

    private val scope = CoroutineScope(Dispatchers.Default)
    private val mainUseCase = MainUseCase(fetchVideo, scope)

    fun emit(intent: MainIntent){
        mainUseCase.emit(intent)
    }

    fun getStates() = mainUseCase.getUiStates()

    fun stopObserving(){
        scope.cancel()
    }

}