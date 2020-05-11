package com.r4mste1n.main.artist_info

import android.os.Bundle
import android.view.View
import com.r4mste1n.R
import com.r4mste1n.main.repositories.ArtistsRepository
import com.r4mste1n.root.base.BaseFragment

/**
 * Created by Alex Shtain on 25.04.2020.
 */
class ArtistInfoFragment : BaseFragment<Contract.Presenter, Contract.View>() {

    override val presenter: Contract.Presenter = ArtistInfoPresenter(ArtistsRepository())
    override val view: Contract.View = ArtistInfoView()
    override val layout: Int = R.layout.fr_artist_info

    companion object {

        const val ARTIST_NAME_KEY = "artist_name_key"

        fun newInstance(artistName: String) = ArtistInfoFragment().apply {
            arguments = Bundle().apply {
                putString(ARTIST_NAME_KEY, artistName)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.setBundleData(arguments)
        super.onViewCreated(view, savedInstanceState)
    }

}