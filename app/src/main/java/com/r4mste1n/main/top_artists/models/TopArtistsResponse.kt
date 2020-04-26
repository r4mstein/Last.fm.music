package com.r4mste1n.main.top_artists.models


import com.google.gson.annotations.SerializedName

data class TopArtistsResponse(
    @SerializedName("artists")
    val artists: Artists? = null
)