package com.dosmono.sanya.architecture.mvi.view.fragment

import android.content.Context
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

import javax.inject.Inject

abstract class InjectionFragment : AutoDisposeFragment(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }



    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}