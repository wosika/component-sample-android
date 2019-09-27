package com.dosmono.sanya.main.mvi

import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.architecture.app.Kits
import com.dosmono.sanya.architecture.app.WTF
import com.dosmono.sanya.architecture.di.AppComponent
import com.dosmono.sanya.component.RouterParty
import com.dosmono.sanya.main.R
import com.dosmono.sanya.main.mvi.MainViewState.ErrorState
import com.dosmono.sanya.architecture.mvi.view.activity.BaseActivity
import com.dosmono.sanya.main.Person
import com.dosmono.sanya.main.di.DaggerMainActivityComponent
import com.jakewharton.rxbinding3.view.clicks
import com.uber.autodispose.autoDisposable
import com.uber.autodispose.autoDispose
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.main_activity_main.*
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@Route(path = RouterParty.Main.MAIN_ACTIVITY)
class MainActivity() : BaseActivity<MainIntent, MainViewState>() {


    override fun daggerInject(appComponent: AppComponent) {
        DaggerMainActivityComponent.builder()
            .activity(this)
            .appComponent(appComponent)
            .build()
            .inject(this)
    }

    override val layoutId = R.layout.main_activity_main


    //初始化意图
    private val mInitIntent: Observable<MainIntent> = Observable.just(MainIntent.InitIntent)
    //刷新意图
    private val mRefreshIntent: PublishSubject<MainIntent.RefreshIntent> = PublishSubject.create()


    @Inject
    lateinit var mViewModel: MainViewModel


    //此时注入进来的wtf对象 是重新创建的
    @Inject
    lateinit var wtf: WTF

    @Inject
    lateinit var person: Person


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        binds()
    }


    private fun binds() {

        //数据绑定
        mViewModel.states()
            .autoDispose(scopeProvider)
            .subscribe(this::render)

        //点击事件
        btn.clicks()
            .debounce(2, TimeUnit.SECONDS)
            .autoDispose(scopeProvider)
            .subscribe {
                ARouter.getInstance().build(RouterParty.Talk.TALK_ACTIVITY).navigation(this)
            }


        //观察意图
        mViewModel.processIntents(intents())
    }


    /**
     * 用户发起操作意图
     * @return Observable<MainIntent>
     */
    override fun intents(): Observable<MainIntent> {
        return Observable.merge(mInitIntent, mRefreshIntent)

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
