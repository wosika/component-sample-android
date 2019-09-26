package com.dosmono.sanya.main

import android.app.Application
import com.dosmono.sanya.component.IModule
import com.dosmono.sanya.component.app.GlobalApp
import com.dosmono.sanya.main.di.DaggerMainModuleComponent
import timber.log.Timber

class MainModuleImpl : IModule {


    override fun onInit(application: Application) {
        //对整个模块进行依赖注入
       // DaggerMainModuleComponent.().create(application).inject(application)
        DaggerMainModuleComponent.builder().application(application).build().inject(application as GlobalApp)
        Timber.d("初始化 main组件")
    }
}