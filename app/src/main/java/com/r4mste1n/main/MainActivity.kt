package com.r4mste1n.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.r4mste1n.R
import com.r4mste1n.main.top_artists.TopArtistsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar as Toolbar)

        showTopArtistsFragment()
    }

    fun showTopArtistsFragment() {
        addFragment(R.id.flRootContainer, TopArtistsFragment.newInstance())
    }

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun showProgressBar() {
        if (pbLoader.visibility == View.GONE) pbLoader.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        if (pbLoader.visibility == View.VISIBLE) pbLoader.visibility = View.GONE
    }

    private fun addFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(containerId, fragment)
            .commit()
    }

    private fun replaceFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    private fun replaceFragmentAndAddToBackStack(containerId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)
            .commit()
    }
}
