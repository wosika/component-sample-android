package com.dosmono.sanya.main.mvi

import com.dosmono.sanya.architecture.mvi.intent.IIntent

sealed class MainIntent : IIntent {

    //初始化的Intent
    object InitIntent : MainIntent()


    /**
     * 刷新界面的意图
     */
    object RefreshIntent : MainIntent()




    /**
     * 查询手机号的意图
     */
    data class CheckPhoneIntent(val phone:String) : MainIntent()
}