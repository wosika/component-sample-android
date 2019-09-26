package com.dosmono.sanya.architecture.app

import android.app.Application
import com.dosmono.sanya.architecture.BuildConfig
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

abstract class BaseApp : Application(), HasAndroidInjector {


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



        initTimber()

    }

    /**
     * 初始化Log工具类
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            //可以在这里自定义一些Log上传到服务器中
        }
    }

    /**
     * 初始化dagger依赖注入
     */
    private fun initDagger() {

        //DaggerAppComponent.factory().create(this).inject(this)
    }
}