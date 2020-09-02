package com.wosika.sanya.main

import android.app.Application
import com.wosika.sanya.component.IModule
import timber.log.Timber

class MainModuleImpl : IModule {


    override fun onInit(application: Application) {
        Timber.d("初始化 main组件")
    }
}