package com.dosmono.sanya.sub

import android.app.Application
import com.dosmono.sanya.component.IModule
import timber.log.Timber

class SubModuleImpl : IModule {

    override fun onInit(application: Application): Boolean {
        Timber.d("初始化 sub组件")
        return true;
    }

}