package com.r4mste1n.root.network.api

import com.r4mste1n.main.artist_info.models.ArtistInfoResponse
import com.r4mste1n.main.top_artists.models.TopArtistsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Alex Shtain on 18.04.2020.
 */
interface LastFmApi {

    @GET("?method=chart.gettopartists")
    suspend fun getTopArtists(
        @Query("limit") limit: Int
    ): TopArtistsResponse

    @GET("?method=artist.getinfo")
    suspend fun getArtistInfo(
        @Query("artist") artist: String
    ): ArtistInfoResponse

}