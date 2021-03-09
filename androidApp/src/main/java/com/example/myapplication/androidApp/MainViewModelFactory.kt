package com.example.myapplication.androidApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.shared.MainViewModel
import com.example.myapplication.shared.api.VideoApiImpl
import com.example.myapplication.shared.domain.FetchVideo
import com.example.myapplication.shared.domain.FetchVideoImpl
import com.example.myapplication.shared.repository.VideoRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.lang.RuntimeException


class MainViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(FetchVideoImpl(VideoRepositoryImpl(VideoApiImpl()))) as T
        } else {
            throw RuntimeException("")
        }
    }
}