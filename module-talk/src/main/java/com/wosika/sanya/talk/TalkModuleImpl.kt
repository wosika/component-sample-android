package com.wosika.sanya.talk

import android.app.Application
import com.wosika.sanya.component.IModule
import timber.log.Timber

class TalkModuleImpl :IModule{
    override fun onInit(application: Application) {
        Timber.d("初始化 talk组件")
    }

}