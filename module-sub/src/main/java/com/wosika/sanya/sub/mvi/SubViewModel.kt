package com.wosika.sanya.sub.mvi

import com.wosika.sanya.architecture.mvi.viewmodel.BaseViewModel
import io.reactivex.Observable

class SubViewModel() : BaseViewModel<SubIntent, SubViewState>() {


    //处理用户发起的意图
    override fun processIntents(intents: Observable<SubIntent>) {


    }


    //返回状态合并以后的观察者
    override fun states(): Observable<SubViewState> {
        return Observable.empty()
    }
}