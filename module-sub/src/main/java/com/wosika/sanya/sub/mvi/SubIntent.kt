package com.wosika.sanya.sub.mvi

import com.wosika.sanya.architecture.mvi.intent.IIntent

sealed class SubIntent : IIntent {

    //初始化的Intent
    object InitIntent : SubIntent()


}