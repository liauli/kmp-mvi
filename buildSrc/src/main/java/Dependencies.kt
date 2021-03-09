object Versions{
    const val ktor = "1.5.2"
}

object Dependencies {
    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val gson = "io.ktor:ktor-client-gson:${Versions.ktor}"
        const val cio = "io.ktor:ktor-client-cio:${Versions.ktor}"
        const val okhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        const val serialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val android = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
    }
}

