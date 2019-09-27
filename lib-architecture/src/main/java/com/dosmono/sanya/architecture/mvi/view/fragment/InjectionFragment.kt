package com.dosmono.sanya.architecture.mvi.view.fragment

import android.content.Context
import com.dosmono.sanya.architecture.app.Kits
import com.dosmono.sanya.architecture.di.AppComponent


import javax.inject.Inject

abstract class InjectionFragment : AutoDisposeFragment() {


    override fun onAttach(context: Context) {
        DaggerInject(Kits.obtainAppComponentFromContext(context))
        super.onAttach(context)
    }

    abstract fun DaggerInject(appComponent: AppComponent)


}