package com.r4mste1n.main.artist_info.models


import com.google.gson.annotations.SerializedName

data class Bio(
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("links")
    val links: Links? = null,
    @SerializedName("published")
    val published: String? = null,
    @SerializedName("summary")
    val summary: String? = null
)

data class Links(
    @SerializedName("link")
    val link: Link? = null
)

data class Link(
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("rel")
    val rel: String? = null,
    @SerializedName("#text")
    val text: String? = null
)

data class Tag(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)