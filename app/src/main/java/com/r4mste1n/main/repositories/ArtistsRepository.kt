package com.r4mste1n.main.repositories

import com.r4mste1n.main.artist_info.models.ArtistInfoResponse
import com.r4mste1n.main.top_artists.models.TopArtistsResponse
import com.r4mste1n.root.network.ErrorUtils
import com.r4mste1n.root.network.NetworkConstants.DEFAULT_ERROR_MESSAGE
import com.r4mste1n.root.network.Result
import com.r4mste1n.root.network.ServiceHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Created by Alex Shtain on 18.04.2020.
 */
private const val TOP_ARTISTS_METHOD = "chart.gettopartists"
private const val TOP_ARTISTS_LIMIT = "100"
private const val ARTIST_INFO_METHOD = "artist.getinfo"

class ArtistsRepository : ArtistsRepositoryContract {

    private var topArtists: TopArtistsResponse? = null

    override fun loadTopArtists(parentJob: Job, listener: (Result<TopArtistsResponse>) -> Unit) {

        if (topArtists != null) {
            listener(Result.Success(topArtists!!))
            return
        }

        CoroutineScope(Dispatchers.Main + parentJob).launch {
            var errorMessage: String? = null
            var response: TopArtistsResponse? = null

            launch(Dispatchers.IO) {
                try {
                    response = ServiceHelper.mainService.getTopArtists(
                        method = TOP_ARTISTS_METHOD,
                        limit = TOP_ARTISTS_LIMIT
                    )
                } catch (exception: HttpException) {
                    errorMessage = ErrorUtils.parseError(exception.response()?.errorBody())
                } catch (exception: Exception) {
                    errorMessage = exception.message
                }
            }.join()

            when (response) {
                null -> listener(Result.Error(errorMessage ?: DEFAULT_ERROR_MESSAGE))
                else -> {
                    topArtists = response
                    listener(Result.Success(response!!))
                }
            }
        }
    }

    override fun loadArtistInfo(
        artistName: String,
        parentJob: Job,
        listener: (Result<ArtistInfoResponse>) -> Unit
    ) {

        CoroutineScope(Dispatchers.Main + parentJob).launch {
            var errorMessage: String? = null
            var response: ArtistInfoResponse? = null

            launch(Dispatchers.IO) {
                try {
                    response = ServiceHelper.mainService.getArtistInfo(
                        method = ARTIST_INFO_METHOD,
                        artist = artistName
                    )
                } catch (exception: HttpException) {
                    errorMessage = ErrorUtils.parseError(exception.response()?.errorBody())
                } catch (exception: Exception) {
                    errorMessage = exception.message
                }
            }.join()

            when (response) {
                null -> listener(Result.Error(errorMessage ?: DEFAULT_ERROR_MESSAGE))
                else -> listener(Result.Success(response!!))
            }
        }
    }

}