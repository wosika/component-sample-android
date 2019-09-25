package com.dosmono.sanya.architecture.mvi.viewmodel
import com.dosmono.sanya.architecture.mvi.intent.IIntent
import com.dosmono.sanya.architecture.mvi.viewstate.IViewState

abstract class BaseViewModel<I : IIntent, VS : IViewState> : IViewModel<I, VS>,
    AutoDisposeViewModel() {

}