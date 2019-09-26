package com.dosmono.sanya.architecture.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.architecture.BuildConfig
import com.dosmono.sanya.architecture.di.DaggerAppComponent
import com.dosmono.sanya.component.ModuleConfig
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject
import timber.log.Timber.DebugTree


class App : Application(), HasAndroidInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    @Inject
    lateinit var appName: String


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector;
    }

    override fun onCreate() {
        super.onCreate()

        initDagger()

        initARouter()

        initTimber()

        //提供让各个模块进行初始化的方法
        ModuleConfig.initModule(this)
    }


    /**
     * 初始化Log工具类
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            //可以在这里自定义一些Log上传到服务器中
        }
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

    /**
     * 初始化dagger依赖注入
     */
    private fun initDagger() {
        DaggerAppComponent.factory().create(this).inject(this)
    }
}