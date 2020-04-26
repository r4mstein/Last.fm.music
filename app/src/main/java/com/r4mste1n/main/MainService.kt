package com.r4mste1n.main

import com.r4mste1n.main.artist_info.models.ArtistInfoResponse
import com.r4mste1n.main.top_artists.models.TopArtistsResponse
import com.r4mste1n.root.network.NetworkConstants.API_VERSION
import com.r4mste1n.root.network.NetworkConstants.QUERY_METHOD
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Alex Shtain on 18.04.2020.
 */
interface MainService {

    @GET(API_VERSION)
    suspend fun getTopArtists(
        @Query(QUERY_METHOD) method: String,
        @Query("limit") limit: String
    ): TopArtistsResponse

    @GET(API_VERSION)
    suspend fun getArtistInfo(
        @Query(QUERY_METHOD) method: String,
        @Query("artist") artist: String
    ): ArtistInfoResponse

}