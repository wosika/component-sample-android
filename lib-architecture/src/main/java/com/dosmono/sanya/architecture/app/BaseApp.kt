package com.dosmono.sanya.architecture.app

import android.app.Application
import com.dosmono.sanya.architecture.BuildConfig
import com.dosmono.sanya.architecture.di.AppComponent
import com.dosmono.sanya.architecture.di.DaggerAppComponent
import timber.log.Timber

abstract class BaseApp : IAPP, Application() {


    private lateinit var mAppComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        initTimber()
        initDagger()

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
        mAppComponent = DaggerAppComponent.factory().create(this).apply { inject(this@BaseApp) }
    }


    override fun getAppComponent(): AppComponent {
        return mAppComponent
    }

}