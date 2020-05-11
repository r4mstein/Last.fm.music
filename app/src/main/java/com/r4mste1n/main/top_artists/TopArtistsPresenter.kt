package com.r4mste1n.main.top_artists

import com.r4mste1n.main.repositories.ArtistsRepositoryContract
import com.r4mste1n.main.top_artists.adapter.AdapterData
import com.r4mste1n.main.top_artists.models.TopArtistsResponse
import com.r4mste1n.root.base.BasePresenter
import com.r4mste1n.root.network.Result
import kotlinx.coroutines.*

/**
 * Created by Alex Shtain on 12.04.2020.
 */
class TopArtistsPresenter(
    private val repository: ArtistsRepositoryContract
) : BasePresenter<Contract.View>(), Contract.Presenter {

    private val parentJob: Job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)

    override fun onViewCreated() {
        loadArtists()
    }

    override fun onStop() {
        super.onStop()
        parentJob.cancelChildren()
    }

    override fun loadArtists() {
        view?.showLoader(true)

        coroutineScope.launch {
            repository.loadTopArtists() { result ->
                when (result) {
                    is Result.Success -> {
                        view?.updateList(convertLoadedDataToUiData(result.data))
                        view?.showLoader(false)
                    }
                    is Result.Error -> {
                        view?.showLoader(false)
                        view?.showError(result.message)
                    }
                }
            }
        }
    }

    private fun convertLoadedDataToUiData(response: TopArtistsResponse) =
        ArrayList<AdapterData>().apply {
            response.artists?.artist?.forEach {
                add(
                    AdapterData(
                        name = it.name,
                        hearersCount = it.listeners,
                        photoUrl = it.image?.getOrNull(2)?.text ?: ""
                    )
                )
            }
        }

}