package com.r4mste1n.main.top_artists.models


import com.google.gson.annotations.SerializedName

data class Attr(
    @SerializedName("page")
    val page: String? = null,
    @SerializedName("perPage")
    val perPage: String? = null,
    @SerializedName("total")
    val total: String? = null,
    @SerializedName("totalPages")
    val totalPages: String? = null
)