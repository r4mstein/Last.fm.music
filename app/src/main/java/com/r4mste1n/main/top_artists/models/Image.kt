package com.r4mste1n.main.top_artists.models


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("#text")
    val text: String? = null
)