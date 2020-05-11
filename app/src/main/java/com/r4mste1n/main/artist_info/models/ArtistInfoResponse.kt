package com.r4mste1n.main.artist_info.models


import com.google.gson.annotations.SerializedName

data class ArtistInfoResponse(
    @SerializedName("artist")
    val artist: Artist? = null
)