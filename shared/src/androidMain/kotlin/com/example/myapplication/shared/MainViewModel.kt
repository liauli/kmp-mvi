package com.example.myapplication.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.shared.api.VideoApi
import com.example.myapplication.shared.api.VideoApiImpl
import com.example.myapplication.shared.domain.FetchVideo
import com.example.myapplication.shared.domain.FetchVideoImpl
import com.example.myapplication.shared.repository.VideoRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


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