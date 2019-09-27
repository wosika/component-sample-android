package com.dosmono.sanya.sub.mvi

import com.dosmono.sanya.architecture.mvi.intent.IIntent

sealed class SubIntent : IIntent {

    //初始化的Intent
    object InitIntent : SubIntent()


}