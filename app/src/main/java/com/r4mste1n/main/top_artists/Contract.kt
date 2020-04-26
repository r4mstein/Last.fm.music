package com.r4mste1n.main.top_artists

import com.r4mste1n.main.top_artists.adapter.AdapterData
import com.r4mste1n.root.base.PresenterContract
import com.r4mste1n.root.base.ViewContract

/**
 * Created by Alex Shtain on 18.04.2020.
 */
interface Contract {

    interface View : ViewContract {

        fun updateList(data: List<AdapterData>)

    }

    interface Presenter : PresenterContract {

        fun loadArtists()

    }
}