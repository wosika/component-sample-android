package com.dosmono.sanya.mvi.view

import com.dosmono.sanya.mvi.intent.IIntent
import com.dosmono.sanya.mvi.viewstate.IViewState
import io.reactivex.Observable

interface IView<I : IIntent, S : IViewState> {

    //产出页面意图
    fun intents(): Observable<I>


    //view的渲染方法
    fun render(state: S)
}