package com.r4mste1n.main.artist_info

import com.r4mste1n.root.base.PresenterContract
import com.r4mste1n.root.base.ViewContract

/**
 * Created by Alex Shtain on 25.04.2020.
 */
interface Contract {

    interface View : ViewContract {

        fun setArtistPhoto(link: String)

        fun setArtistName(name: String)

        fun setArtistTags(tags: List<String>)

        fun setListenersCount(count: String)

        fun setPlayCount(count: String)

        fun setBio(bio: String)

        fun setBioPublished(date: String)

    }

    interface Presenter : PresenterContract
}