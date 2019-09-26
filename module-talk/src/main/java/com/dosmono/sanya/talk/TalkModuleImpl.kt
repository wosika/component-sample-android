package com.dosmono.sanya.talk

import android.app.Application
import com.dosmono.sanya.component.IModule
import timber.log.Timber

class TalkModuleImpl :IModule{
    override fun onInit(application: Application): Boolean {

        Timber.d("初始化 talk组件")
        return true;
    }

}