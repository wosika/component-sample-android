package com.dosmono.sanya.architecture.mvi.view.activity

import android.os.Bundle
import com.dosmono.sanya.architecture.app.Kits
import com.dosmono.sanya.architecture.di.AppComponent
import javax.inject.Inject

abstract class InjectionActivity : AutoDisposeActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInject(Kits.obtainAppComponentFromContext(this))
        super.onCreate(savedInstanceState)
    }

    abstract fun daggerInject(appComponent: AppComponent)


}