package com.liauli.kmp.shared.model

import com.liauli.kmp.shared.Video
import kotlinx.serialization.Serializable

@Serializable
data class Playlist(val play_list: List<Video>)
