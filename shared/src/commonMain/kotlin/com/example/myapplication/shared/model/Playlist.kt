package com.example.myapplication.shared.model

import com.example.myapplication.shared.Video
import kotlinx.serialization.Serializable

@Serializable
data class Playlist(val play_list: List<Video>)
