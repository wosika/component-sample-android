package com.dosmono.sanya.mvi

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.base.RouterParty
import com.dosmono.sanya.main.R
import com.dosmono.sanya.mvi.MainViewState.ErrorState
import com.dosmono.sanya.architecture.mvi.view.activity.BaseActivity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.main_activity_main.*

@Route(path = RouterParty.Main.MAIN_ACTIVITY)
class MainActivity() : BaseActivity<MainIntent, MainViewState>() {
    override val layoutId = R.layout.main_activity_main

    private val intentSubject: PublishSubject<MainIntent> = PublishSubject.create()


    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        initViewModel()


        btn.setOnClickListener {
            ARouter.getInstance().build(RouterParty.Sub.SUB_ACTIVITY).navigation();
        }


        NetworkUtils.getPhoneState(this)
    }




    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

    }


    /**
     * 用户发起操作意图
     * @return Observable<MainIntent>
     */
    override fun intents(): Observable<MainIntent> {
        return intentSubject.startWith(MainIntent.InitIntent).map { MainIntent.RefreshIntent(1) }
    }

    /**
     * 逻辑处理之后返回数据操作ui
     * @param state MainViewState
     */
    override fun render(state: MainViewState) {

        showMessage("是否在加载中$state.isLoading")

        when (state) {
            is ErrorState -> showMessage(state.error?.message)
            is MainViewState.SuccessState -> showMessage(state.data)
        }
    }


    private fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
