package com.dosmono.sanya.component.app

import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.architecture.BuildConfig
import com.dosmono.sanya.architecture.app.BaseApp
import com.dosmono.sanya.component.ModuleConfig

class GlobalApp : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        initARouter()

        //提供让各个模块进行初始化的方法
        ModuleConfig.initModule(this)
    }

    /**
     * 初始化 Arouter组件化
     */
    private fun initARouter() {
        if (BuildConfig.DEBUG) {//Timber日志打印
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.monitorMode()
        }
        ARouter.init(this)
    }
}