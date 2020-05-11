package com.r4mste1n.main.artist_info

import com.r4mste1n.main.artist_info.ArtistInfoFragment.Companion.ARTIST_NAME_KEY
import com.r4mste1n.main.artist_info.models.Artist
import com.r4mste1n.main.artist_info.models.UiData
import com.r4mste1n.main.repositories.ArtistsRepositoryContract
import com.r4mste1n.root.base.BasePresenter
import com.r4mste1n.root.network.Result
import kotlinx.coroutines.*

/**
 * Created by Alex Shtain on 25.04.2020.
 */
class ArtistInfoPresenter(
    private val repository: ArtistsRepositoryContract
) : BasePresenter<Contract.View>(), Contract.Presenter {

    private val parentJob: Job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)

    override fun onViewCreated() {
        loadArtistInfo()
    }

    override fun onStop() {
        super.onStop()
        parentJob.cancelChildren()
    }

    private fun loadArtistInfo() {
        view?.showLoader(true)

        coroutineScope.launch {
            repository.loadArtistInfo(bundle?.getString(ARTIST_NAME_KEY) ?: "") { result ->
                when (result) {
                    is Result.Success -> {
                        view?.apply {
                            val uiData = convertLoadedDataToUiData(result.data.artist)

                            setArtistPhoto(uiData.artistPhoto)
                            setArtistName(uiData.artistName)
                            setArtistTags(uiData.artistTags)
                            setHearersCount(uiData.hearersCount)
                            setPlayCount(uiData.playCount)
                            setBio(uiData.bio)
                            setBioPublished(uiData.bioPublished)

                            showLoader(false)
                        }
                    }
                    is Result.Error -> {
                        view?.showLoader(false)
                        view?.showError(result.message)
                    }
                }
            }
        }
    }

    private fun convertLoadedDataToUiData(artist: Artist?) = UiData(
        artistPhoto = artist?.image?.getOrNull(2)?.text ?: "",
        artistName = artist?.name ?: "",
        artistTags = artist?.tags?.tag?.let {
            val uiTags = ArrayList<String>(artist.tags.tag.size)

            it.forEach { tag ->
                tag.name?.let { tagName -> uiTags.add(tagName) }
            }

            uiTags
        } ?: emptyList(),
        hearersCount = artist?.stats?.listeners ?: "",
        playCount = artist?.stats?.playcount ?: "",
        bio = artist?.bio?.content ?: "",
        bioPublished = artist?.bio?.published ?: ""
    )

}