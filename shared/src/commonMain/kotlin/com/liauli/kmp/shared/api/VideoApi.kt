package com.liauli.kmp.shared.api

import com.liauli.kmp.shared.model.Playlist

interface VideoApi {

    suspend fun fetchVideo(): Playlist
}
