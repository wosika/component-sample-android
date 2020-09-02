package com.wosika.sanya.architecture.mvi.viewmodel
import com.wosika.sanya.architecture.mvi.intent.IIntent
import com.wosika.sanya.architecture.mvi.viewstate.IViewState

abstract class BaseViewModel<I : IIntent, VS : IViewState> : IViewModel<I, VS>,
    AutoDisposeViewModel() {

}