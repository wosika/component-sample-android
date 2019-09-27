package com.dosmono.sanya.main.mvi

import com.dosmono.sanya.architecture.app.WTF
import com.dosmono.sanya.architecture.mvi.viewmodel.BaseViewModel
import com.dosmono.sanya.main.Person
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class MainViewModel(): BaseViewModel<MainIntent, MainViewState>() {



    //处理用户发起的意图
    override fun processIntents(intents: Observable<MainIntent>) {


    }


    //返回状态合并以后的观察者
    override fun states(): Observable<MainViewState> {
       return Observable.empty()
    }
}