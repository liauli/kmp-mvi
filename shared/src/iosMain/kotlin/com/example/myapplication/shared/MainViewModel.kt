package com.example.myapplication.shared

import com.example.myapplication.shared.domain.FetchVideo
import com.example.myapplication.shared.domain.FetchVideoImpl
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


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