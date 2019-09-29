package com.dosmono.sanya.main.mvi

import com.dosmono.sanya.architecture.app.WTF
import com.dosmono.sanya.architecture.mvi.viewmodel.BaseViewModel
import com.dosmono.sanya.main.Person
import com.uber.autodispose.autoDispose
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject

class MainViewModel : BaseViewModel<MainIntent, MainViewState>() {


    private val intentSubject: PublishSubject<MainIntent> = PublishSubject.create()

    private val statesObservable: Observable<MainViewState> = compose()

    private fun compose(): Observable<MainViewState> {

        return intentSubject
            .flatMap {
                return@flatMap when (it) {
                    is MainIntent.RefreshIntent -> Observable.just<MainViewState>(MainViewState.LoadingState())
                    else -> return@flatMap Observable.just<MainViewState>(MainViewState.SuccessState("返回的数据"))
                }
            }
            .distinctUntilChanged()
            // Emit the last one event of the stream on subscription
            // Useful when a View rebinds to the ViewModel after rotation.
            .replay(1)
            // Create the stream on creation without waiting for anyone to subscribe
            // This allows the stream to stay alive even when the UI disconnects and
            // match the stream's lifecycle to the ViewModel's one.
            .autoConnect(0)
    }


    //处理用户发起的意图
    override fun processIntents(intents: Observable<MainIntent>) {
        intents.autoDispose(this).subscribe(intentSubject)

    }


    //返回状态合并以后的观察者
    override fun states(): Observable<MainViewState> {
        return statesObservable
    }
}