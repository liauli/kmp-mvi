package com.example.myapplication.shared.api

import com.example.myapplication.shared.model.Playlist

interface VideoApi {

    suspend fun fetchVideo(): Playlist?
}
