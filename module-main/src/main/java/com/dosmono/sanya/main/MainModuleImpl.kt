package com.dosmono.sanya.main

import android.app.Application
import com.dosmono.sanya.component.IModule
import timber.log.Timber

class MainModuleImpl : IModule {


    override fun onInit(application: Application) {
        Timber.d("初始化 main组件")
    }
}