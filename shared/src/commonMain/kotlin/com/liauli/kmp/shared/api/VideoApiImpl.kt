package com.liauli.kmp.shared.api

import com.liauli.kmp.shared.model.Playlist
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.json.Json

class VideoApiImpl : VideoApi {

    private val url = "https://gist.githubusercontent.com/" +
            "ayinozendy/a1f7629d8760c0d9cd4a5a4f051d111c/" +
            "raw/6ead19b28382af688e8b4426d2310f0468a2fb5f/playlist.json"

    override suspend fun fetchVideo() : Playlist{
        val client = createClient()
        return client.use {
           client.get(url)
        }
    }

    private fun createClient() : HttpClient{
        val nonStrictJson =
            Json { isLenient = true; ignoreUnknownKeys = true }

        return HttpClient {
            install(JsonFeature) {
                accept(ContentType.Text.Plain)
                serializer = KotlinxSerializer(nonStrictJson)
            }
        }
    }
}
