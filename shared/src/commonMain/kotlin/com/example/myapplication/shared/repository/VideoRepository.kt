package com.example.myapplication.shared.repository

import com.example.myapplication.shared.model.Playlist
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    suspend fun fetchVideo() : Flow<Playlist?>

    fun getVideo()
}
