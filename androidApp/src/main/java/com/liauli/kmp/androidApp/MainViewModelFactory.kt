package com.liauli.kmp.androidApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.liauli.kmp.shared.MainViewModel
import com.liauli.kmp.shared.api.VideoApiImpl
import com.liauli.kmp.shared.domain.FetchVideoImpl
import com.liauli.kmp.shared.repository.VideoRepositoryImpl
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