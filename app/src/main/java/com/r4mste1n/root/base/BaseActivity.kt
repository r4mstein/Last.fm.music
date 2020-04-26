package com.r4mste1n.root.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by Alex Shtain on 25.04.2020.
 */
abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setupUI()
    }

    abstract fun setupUI()

    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    protected fun addFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(containerId, fragment)
            .commit()
    }

    protected fun replaceFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    protected fun replaceFragmentAndAddToBackStack(containerId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)
            .commit()
    }
}