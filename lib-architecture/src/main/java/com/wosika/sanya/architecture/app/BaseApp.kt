package com.wosika.sanya.architecture.app

import android.app.Application
import com.wosika.sanya.architecture.BuildConfig
import com.wosika.sanya.architecture.di.AppComponent
import com.wosika.sanya.architecture.di.DaggerAppComponent
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

abstract class BaseApp : IAPP, Application() {


    private lateinit var mAppComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        initTimber()
        initDagger()
        initRxJava()

    }

    private fun initRxJava() {
        //定义一个onerror handler，防止没有复写onerror时出现的崩溃
        RxJavaPlugins.setErrorHandler { t: Throwable? -> t?.printStackTrace() }
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