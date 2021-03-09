package com.example.myapplication.shared.domain

import com.example.myapplication.shared.Video
import com.example.myapplication.shared.model.Playlist
import com.example.myapplication.shared.repository.VideoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow

class FetchVideoImpl(private val videoRepository: VideoRepository) : FetchVideo {
    // Used only on iOs
    private val coroutineScope: CoroutineScope = MainScope()

    private val handler = CoroutineExceptionHandler { _, exception ->
       print(exception.message)
    }

    override suspend fun execute(): Flow<Playlist?> {
        return videoRepository.fetchVideo()
    }

    override fun execute(success: (List<Video>) -> Unit) {
        coroutineScope.launch(handler) {
            videoRepository.fetchVideo().collect {
                success(it?.play_list?: emptyList())
            }
        }
    }

    // iOs only
    fun onDestroy() {
        coroutineScope.cancel()
    }
}
