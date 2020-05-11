package com.r4mste1n.main.top_artists

import com.r4mste1n.R
import com.r4mste1n.main.repositories.ArtistsRepository
import com.r4mste1n.root.base.BaseFragment

/**
 * Created by Alex Shtain on 12.04.2020.
 */
class TopArtistsFragment : BaseFragment<Contract.Presenter, Contract.View>() {

    override val presenter: Contract.Presenter = TopArtistsPresenter(ArtistsRepository())
    override val view: Contract.View = TopArtistsView()
    override val layout: Int = R.layout.fr_top_artists

    companion object {
        fun newInstance() = TopArtistsFragment()
    }

}