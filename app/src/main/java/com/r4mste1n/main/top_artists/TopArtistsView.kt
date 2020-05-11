package com.r4mste1n.main.top_artists

import androidx.recyclerview.widget.LinearLayoutManager
import com.r4mste1n.R
import com.r4mste1n.main.MainActivity
import com.r4mste1n.main.top_artists.adapter.Adapter
import com.r4mste1n.main.top_artists.adapter.AdapterData
import com.r4mste1n.root.base.BaseActivity
import com.r4mste1n.root.base.BaseView
import kotlinx.android.synthetic.main.fr_top_artists.view.*

/**
 * Created by Alex Shtain on 18.04.2020.
 */
class TopArtistsView() : BaseView<Contract.Presenter>(), Contract.View {

    private lateinit var listAdapter: Adapter

    override fun setupUI() {
        (context as BaseActivity).setToolbarTitle(context?.getString(R.string.top_artists_toolbar_title) ?: "")
        setupList()
    }

    private fun setupList() {
        listAdapter = Adapter(clickListener)
        rootView?.rvList?.apply {
            layoutManager = LinearLayoutManager(rootView.context)
            adapter = listAdapter
        }
    }

    private val clickListener: (item: AdapterData) -> Unit = {
        (context as MainActivity).showArtistInfo(it.name ?: "")
    }

    override fun updateList(data: List<AdapterData>) {
        listAdapter.setData(data)
    }

}