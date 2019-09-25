package com.dosmono.sanya.mvi

import com.dosmono.sanya.architecture.mvi.viewmodel.BaseViewModel
import io.reactivex.Observable

class MainViewModel(): BaseViewModel<MainIntent, MainViewState>() {




    //处理用户发起的意图
    override fun processIntents(intents: Observable<MainIntent>) {

    }


    //返回状态合并以后的观察者
    override fun states(): Observable<MainViewState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}