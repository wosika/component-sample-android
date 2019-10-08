package com.dosmono.sanya.main.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dosmono.sanya.architecture.mvi.viewmodel.BaseViewModel
import com.uber.autodispose.autoDispose
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class MainViewModel(private val mRepo: MainRepository) :
    BaseViewModel<MainIntent, MainViewState>() {


    private val intentSubject: PublishSubject<MainIntent> = PublishSubject.create()

    private val statesObservable: Observable<MainViewState> = compose()


    private fun compose(): Observable<MainViewState> {

        return intentSubject
            .map<MainViewState>(this::actionFromIntent)
            .startWith { MainViewState.LoadingState() }
            .distinctUntilChanged()
            // Emit the last one event of the stream on subscription
            // Useful when a View rebinds to the ViewModel after rotation.
            .replay(1)
            // Create the stream on creation without waiting for anyone to subscribe
            // This allows the stream to stay alive even when the UI disconnects and
            // match the stream's lifecycle to the ViewModel's one.
            .autoConnect(0)





    }

    private fun actionFromIntent(intent: MainIntent): MainViewState {
        return MainViewState.SuccessState("成功的数据")
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

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val mRepo: MainRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(mRepo) as T
}