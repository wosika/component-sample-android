package com.dosmono.sanya.mvi

import com.dosmono.sanya.architecture.mvi.intent.IIntent

sealed class MainIntent : IIntent {

    //初始化的Intent
    object InitIntent : MainIntent()


    /**
     * 传入要刷新的页数
     * @property page Int
     * @constructor
     */
    data class RefreshIntent(val page: Int) : MainIntent()


}