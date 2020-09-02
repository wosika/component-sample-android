package com.wosika.sanya.architecture.mvi.view.activity

import android.os.Bundle
import com.wosika.sanya.architecture.mvi.intent.IIntent
import com.wosika.sanya.architecture.mvi.view.IView
import com.wosika.sanya.architecture.mvi.viewstate.IViewState



abstract class BaseActivity<I : IIntent, VS : IViewState> : IView<I, VS>, InjectionActivity() {

    //设置布局文件
    protected abstract val layoutId: Int



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }



}