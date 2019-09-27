package com.dosmono.sanya.architecture.mvi.view.fragment

import android.content.Context


import javax.inject.Inject

abstract class InjectionFragment : AutoDisposeFragment() {


    override fun onAttach(context: Context) {
        DaggerInject()
        super.onAttach(context)
    }

    abstract fun DaggerInject()


}