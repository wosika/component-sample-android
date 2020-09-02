package com.wosika.sanya.architecture.mvi.view.activity

import android.os.Bundle
import com.wosika.sanya.architecture.app.Kits
import com.wosika.sanya.architecture.di.AppComponent

abstract class InjectionActivity : AutoDisposeActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInject(Kits.obtainAppComponentFromContext(this))
        super.onCreate(savedInstanceState)
    }

    abstract fun daggerInject(appComponent: AppComponent)


}