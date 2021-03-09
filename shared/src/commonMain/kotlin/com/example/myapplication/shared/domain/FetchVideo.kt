package com.example.myapplication.shared.domain

import com.example.myapplication.shared.Video
import com.example.myapplication.shared.model.Playlist
import kotlinx.coroutines.flow.Flow

interface FetchVideo {
    fun execute(success: (List<Video>) -> Unit)

    suspend fun execute(): Flow<Playlist?>

}
