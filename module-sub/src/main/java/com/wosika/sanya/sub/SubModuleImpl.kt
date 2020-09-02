package com.wosika.sanya.sub

import android.app.Application
import com.wosika.sanya.component.IModule
import timber.log.Timber

class SubModuleImpl : IModule {

    override fun onInit(application: Application) {
        Timber.d("初始化 sub组件")
    }

}