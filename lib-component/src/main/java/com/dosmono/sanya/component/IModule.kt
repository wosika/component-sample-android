package com.dosmono.sanya.component

import android.app.Application

/**
 * 组件初始化的接口
 */
interface IModule {

    /**
     * 将application传入
     * @param application Application
     *
     */
    fun onInit(application: Application)


}