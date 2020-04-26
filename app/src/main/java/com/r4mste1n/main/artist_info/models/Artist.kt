package com.r4mste1n.main.artist_info.models

import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("bio")
    val bio: Bio? = null,
    @SerializedName("image")
    val image: List<Image>? = null,
    @SerializedName("mbid")
    val mbid: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("ontour")
    val ontour: String? = null,
    @SerializedName("similar")
    val similar: Similar? = null,
    @SerializedName("stats")
    val stats: Stats? = null,
    @SerializedName("streamable")
    val streamable: String? = null,
    @SerializedName("tags")
    val tags: Tags? = null,
    @SerializedName("url")
    val url: String? = null
)

data class Image(
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("#text")
    val text: String? = null
)

data class Tags(
    @SerializedName("tag")
    val tag: List<Tag>? = null
)

data class Stats(
    @SerializedName("listeners")
    val listeners: String? = null,
    @SerializedName("playcount")
    val playcount: String? = null
)

data class Similar(
    @SerializedName("artist")
    val artist: List<Artist>? = null
)