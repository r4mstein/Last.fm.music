package com.r4mste1n.main.repositories

import com.r4mste1n.main.artist_info.models.ArtistInfoResponse
import com.r4mste1n.main.top_artists.models.TopArtistsResponse
import com.r4mste1n.root.network.Result

/**
 * Created by Alex Shtain on 18.04.2020.
 */
interface ArtistsRepositoryContract {

    suspend fun loadTopArtists(
        listener: (Result<TopArtistsResponse>) -> Unit
    )

    suspend fun loadArtistInfo(
        artistName: String,
        listener: (Result<ArtistInfoResponse>) -> Unit
    )

}