package com.wosika.sanya.architecture.mvi.view

import com.wosika.sanya.architecture.mvi.intent.IIntent
import com.wosika.sanya.architecture.mvi.viewstate.IViewState
import io.reactivex.Observable

interface IView<I : IIntent, S : IViewState> {

    //产出页面意图
    fun intents(): Observable<I>


    //view的渲染方法
    fun render(state: S)
}