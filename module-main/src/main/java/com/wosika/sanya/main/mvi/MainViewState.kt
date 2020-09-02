package com.wosika.sanya.main.mvi

import com.wosika.sanya.architecture.mvi.viewstate.IViewState

sealed class MainViewState(

    val error: Throwable?,
    val data: String?,
    val isLoading: Boolean
) : IViewState {

    class ErrorState(error: Throwable) : MainViewState(error, null, false)

    class SuccessState(data: String) : MainViewState(null, data, false)

    class LoadingState() : MainViewState(null, null, true)

    class CheckSuccessState(data: String) : MainViewState(null, data, false)

}