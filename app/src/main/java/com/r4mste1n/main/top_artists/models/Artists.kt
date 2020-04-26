package com.r4mste1n.main.top_artists.models


import com.google.gson.annotations.SerializedName

data class Artists(
    @SerializedName("artist")
    val artist: List<Artist>? = null,
    @SerializedName("@attr")
    val attr: Attr? = null
)