package com.r4mste1n.root.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Alex Shtain on 24.04.2020.
 */
abstract class BaseFragment<P : PresenterContract, V : ViewContract> : Fragment() {

    protected abstract val presenter: P
    protected abstract val view: V
    protected abstract val layout: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contentView = inflater.inflate(layout, container, false)

        view.setContentView(contentView)
        presenter.setContractView(view)

        view.onFinishedInflate(presenter)
        presenter.onCreateView()

        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.removeContractView()
        view.removePresenter()
    }

}