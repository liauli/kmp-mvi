package com.example.myapplication.shared.repository

import com.example.myapplication.shared.api.VideoApi
import com.example.myapplication.shared.model.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VideoRepositoryImpl(private val videoApi: VideoApi) : VideoRepository {
    override suspend fun fetchVideo(): Flow<Playlist?> {
        return flow {

            println("fetchVideo-repo")
            emit(videoApi.fetchVideo())
        }
    }

    override fun getVideo() {
        TODO("Not yet implemented")
    }
}
