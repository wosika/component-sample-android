package com.dosmono.sanya.architecture.mvi.view.activity

import android.os.Bundle
import com.dosmono.sanya.architecture.mvi.intent.IIntent
import com.dosmono.sanya.architecture.mvi.view.IView
import com.dosmono.sanya.architecture.mvi.viewstate.IViewState



abstract class BaseActivity<I : IIntent, VS : IViewState> : IView<I, VS>, AutoDisposeActivity() {

    //设置布局文件
    protected abstract val layoutId: Int



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }



}