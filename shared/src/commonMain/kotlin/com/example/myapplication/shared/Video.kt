package com.example.myapplication.shared

import kotlinx.serialization.Serializable

@Serializable
data class Video(val id:String, val description:String, val video_url: String, val author:String, val thumbnail_url:String, val title: String)
//data class Video(
//    val title: String, val presenter_name: String, val description: String,
//    val thumbnail_url: String, val video_url: String, val video_duration: Long
//)

