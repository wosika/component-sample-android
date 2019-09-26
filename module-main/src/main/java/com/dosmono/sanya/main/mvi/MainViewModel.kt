package com.dosmono.sanya.main.mvi

import com.dosmono.sanya.architecture.app.WTF
import com.dosmono.sanya.architecture.mvi.viewmodel.BaseViewModel
import io.reactivex.Observable
import javax.inject.Inject

class MainViewModel(): BaseViewModel<MainIntent, MainViewState>() {
    @Inject
    lateinit var wtf: WTF



    //处理用户发起的意图
    override fun processIntents(intents: Observable<MainIntent>) {
//        Timber.d("MainViewModel看看wtf的属性是不是单例$wtf")
    }


    //返回状态合并以后的观察者
    override fun states(): Observable<MainViewState> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}