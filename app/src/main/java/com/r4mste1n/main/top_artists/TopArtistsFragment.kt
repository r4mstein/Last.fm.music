package com.r4mste1n.main.top_artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.r4mste1n.R
import com.r4mste1n.main.MainActivity

/**
 * Created by Alex Shtain on 12.04.2020.
 */
class TopArtistsFragment : Fragment() {

    companion object {
        fun newInstance() = TopArtistsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_top_artists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbarTitle(resources.getString(R.string.top_artists_toolbar_title))
    }
}