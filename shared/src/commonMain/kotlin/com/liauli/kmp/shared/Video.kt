package com.liauli.kmp.shared

import kotlinx.serialization.Serializable

@Serializable
data class Video(val id:String, val description:String, val video_url: String, val author:String, val thumbnail_url:String, val title: String)


