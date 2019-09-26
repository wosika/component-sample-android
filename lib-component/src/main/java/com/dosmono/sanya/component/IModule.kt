package com.dosmono.sanya.component

import android.app.Application

/**
 * 组件初始化的接口
 */
interface IModule {

    /**
     * 将application传入
     * @param application Application
     * @return Boolean true时初始化成功，false初始化失败
     */
    fun onInit(application: Application): Boolean


}