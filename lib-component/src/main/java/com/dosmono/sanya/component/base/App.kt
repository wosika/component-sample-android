package com.dosmono.sanya.component.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.component.BuildConfig
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector


import javax.inject.Inject

class App : Application(), HasAndroidInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>




    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector;
    }

    override fun onCreate() {
        super.onCreate()

        initDagger()

        if (BuildConfig.DEBUG) {//Timber日志打印
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.monitorMode()
        }
        ARouter.init(this)
    }

    private fun initDagger() {
           // DaggerAppComponent.builder().build()
        //DaggerAppComponent.builder().application(this).build().inject(this)

        //DaggerAppComponent.builder().application(this).build()
    }
}