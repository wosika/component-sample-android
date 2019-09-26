package com.dosmono.sanya.architecture.app

import android.app.Application
import com.dosmono.sanya.architecture.BuildConfig
import com.dosmono.sanya.architecture.di.AppComponent
import com.dosmono.sanya.architecture.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

abstract class BaseApp : IAPP, Application(), HasAndroidInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    @Inject
    lateinit var wtf: WTF


    private lateinit var appComponent: AppComponent


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector;
    }


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
        appComponent = DaggerAppComponent.factory().create(this).also {
            it.inject(this)
        }

        Timber.d("看看wtf是不是单例$wtf")
    }


    override fun getAppComponent(): AppComponent {
        return appComponent
    }

}