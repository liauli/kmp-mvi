package com.liauli.kmp.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liauli.kmp.shared.domain.FetchVideo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow


@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel(fetchVideo: FetchVideo) : ViewModel(){

    // move to constructor when introducing koin
    private val useCase: MainUseCase = MainUseCase(fetchVideo, viewModelScope)

    fun emit(intent: MainIntent){
        useCase.emit(intent)
    }

    fun getUiStates(): MutableStateFlow<MainState> {
       return useCase.getUiStates()
    }

}