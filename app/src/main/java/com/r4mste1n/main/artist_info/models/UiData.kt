package com.r4mste1n.main.artist_info.models

/**
 * Created by Alex Shtain on 26.04.2020.
 */
data class UiData(
    val artistPhoto: String,
    val artistName: String,
    val artistTags: List<String>,
    val listenersCount: String,
    val playCount: String,
    val bio: String,
    val bioPublished: String
)
