package com.r4mste1n.main.top_artists.models


import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("image")
    val image: List<Image>? = null,
    @SerializedName("listeners")
    val listeners: String? = null,
    @SerializedName("mbid")
    val mbid: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("playcount")
    val playcount: String? = null,
    @SerializedName("streamable")
    val streamable: String? = null,
    @SerializedName("url")
    val url: String? = null
)