package com.dosmono.sanya.basic.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.dosmono.sanya.basic.BuildConfig



class BasicApp :Application(){
    override fun onCreate() {
        super.onCreate()


        if (BuildConfig.LOG_DEBUG) {//Timber日志打印
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)


    }
}