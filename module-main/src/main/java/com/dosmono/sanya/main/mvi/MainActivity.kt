package com.dosmono.sanya.main.mvi

import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.component.RouterParty
import com.dosmono.sanya.main.R
import com.dosmono.sanya.main.mvi.MainViewState.ErrorState
import com.dosmono.sanya.architecture.mvi.view.activity.BaseActivity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.main_activity_main.*
import javax.inject.Inject

@Route(path = RouterParty.Main.MAIN_ACTIVITY)
class MainActivity() : BaseActivity<MainIntent, MainViewState>() {

    override val layoutId = R.layout.main_activity_main

    private val intentSubject: PublishSubject<MainIntent> = PublishSubject.create()

    @Inject
    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        
        btn.setOnClickListener {
            ARouter.getInstance().build(RouterParty.Sub.SUB_ACTIVITY).navigation();
        }


        NetworkUtils.getPhoneState(this)
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
