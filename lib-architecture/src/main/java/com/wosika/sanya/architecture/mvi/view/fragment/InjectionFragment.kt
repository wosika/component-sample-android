package com.wosika.sanya.architecture.mvi.view.fragment

import android.content.Context
import com.wosika.sanya.architecture.app.Kits
import com.wosika.sanya.architecture.di.AppComponent

abstract class InjectionFragment : AutoDisposeFragment() {


    override fun onAttach(context: Context) {
        DaggerInject(Kits.obtainAppComponentFromContext(context))
        super.onAttach(context)
    }

    abstract fun DaggerInject(appComponent: AppComponent)


}