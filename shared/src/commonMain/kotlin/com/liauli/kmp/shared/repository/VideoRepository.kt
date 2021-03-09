package com.liauli.kmp.shared.repository

import com.liauli.kmp.shared.model.Playlist
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    suspend fun fetchVideo() : Flow<Playlist?>

    fun getVideo()
}
