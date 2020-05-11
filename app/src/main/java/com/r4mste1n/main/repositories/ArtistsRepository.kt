package com.r4mste1n.main.repositories

import com.r4mste1n.main.artist_info.models.ArtistInfoResponse
import com.r4mste1n.main.top_artists.models.TopArtistsResponse
import com.r4mste1n.root.network.ErrorUtils
import com.r4mste1n.root.network.Result
import com.r4mste1n.root.network.api.LastFmApiHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Created by Alex Shtain on 18.04.2020.
 */
private const val TOP_ARTISTS_LIMIT = 100

class ArtistsRepository : ArtistsRepositoryContract {

    private var topArtists: TopArtistsResponse? = null

    override suspend fun loadTopArtists(listener: (Result<TopArtistsResponse>) -> Unit) {

        if (topArtists != null) {
            listener(Result.Success(topArtists!!))
            return
        }

        var errorMessage: String? = null
        var response: TopArtistsResponse? = null

        CoroutineScope(Dispatchers.IO).launch() {
            try {
                response = LastFmApiHelper.lastFmApi.getTopArtists(
                    limit = TOP_ARTISTS_LIMIT
                )
            } catch (exception: HttpException) {
                errorMessage = ErrorUtils.parseError(exception.response()?.errorBody())
            } catch (exception: Exception) {
                errorMessage = exception.message
            }
        }.join()

        when (response) {
            null -> listener(Result.Error(errorMessage))
            else -> {
                topArtists = response
                listener(Result.Success(response!!))
            }
        }
    }

    override suspend fun loadArtistInfo(
        artistName: String,
        listener: (Result<ArtistInfoResponse>) -> Unit
    ) {

        var errorMessage: String? = null
        var response: ArtistInfoResponse? = null

        CoroutineScope(Dispatchers.IO).launch() {
            try {
                response = LastFmApiHelper.lastFmApi.getArtistInfo(
                    artist = artistName
                )
            } catch (exception: HttpException) {
                errorMessage = ErrorUtils.parseError(exception.response()?.errorBody())
            } catch (exception: Exception) {
                errorMessage = exception.message
            }
        }.join()

        when (response) {
            null -> listener(Result.Error(errorMessage))
            else -> listener(Result.Success(response!!))
        }
    }

}