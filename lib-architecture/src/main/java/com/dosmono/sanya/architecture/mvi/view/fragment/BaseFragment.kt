package com.dosmono.sanya.architecture.mvi.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dosmono.sanya.architecture.mvi.intent.IIntent
import com.dosmono.sanya.architecture.mvi.view.IView
import com.dosmono.sanya.architecture.mvi.viewstate.IViewState

abstract class BaseFragment<I : IIntent, S : IViewState> : InjectionFragment()
    , IView<I, S> {

    private var mRootView: View? = null

    protected abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mRootView = LayoutInflater.from(context).inflate(layoutId, container, false)
        return mRootView!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mRootView = null
    }
}
