package com.liauli.kmp.shared.repository

import com.liauli.kmp.shared.api.VideoApi
import com.liauli.kmp.shared.model.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VideoRepositoryImpl(private val videoApi: VideoApi) : VideoRepository {
    override suspend fun fetchVideo(): Flow<Playlist?> {
        return flow {
            emit(videoApi.fetchVideo())
        }
    }

    override fun getVideo() {
        TODO("Not yet implemented")
    }
}
