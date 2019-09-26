package com.dosmono.sanya.component

import android.app.Application


/**
 * 作为组件生命周期初始化的配置类，通过反射机制，动态调用每个组件初始化逻辑
 */

object ModuleConfig {
    //初始化组件-靠前
    fun initModule(application: Application) {
        for (moduleInitName in ModuleParty.MODULES) {
            try {
                val clazz = Class.forName(moduleInitName)
                val init = clazz.newInstance() as IModule
                //调用初始化方法
                init.onInit(application)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        }
    }

}
