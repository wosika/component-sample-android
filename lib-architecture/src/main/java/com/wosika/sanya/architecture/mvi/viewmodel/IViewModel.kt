package com.wosika.sanya.architecture.mvi.viewmodel

import com.wosika.sanya.architecture.mvi.intent.IIntent
import com.wosika.sanya.architecture.mvi.viewstate.IViewState
import io.reactivex.Observable

interface IViewModel<I: IIntent,VS: IViewState> {
    //处理产生的意图
    fun processIntents(intents: Observable<I>)

    //返回状态的观察者
    fun states(): Observable<VS>
}