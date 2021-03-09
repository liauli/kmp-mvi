package com.liauli.kmp.shared.domain

import com.liauli.kmp.shared.Video
import com.liauli.kmp.shared.model.Playlist
import kotlinx.coroutines.flow.Flow

interface FetchVideo {
    fun execute(success: (List<Video>) -> Unit)

    suspend fun execute(): Flow<Playlist?>

}
