package com.dosmono.sanya.main.mvi

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

import com.dosmono.sanya.architecture.di.AppComponent
import com.dosmono.sanya.component.RouterParty
import com.dosmono.sanya.main.R
import com.dosmono.sanya.architecture.mvi.view.activity.BaseActivity
import com.dosmono.sanya.main.di.DaggerMainActivityComponent
import com.jakewharton.rxbinding3.view.clicks
import com.uber.autodispose.autoDispose
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.main_activity_main.*
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


    //刷新意图
    private val mRefreshIntent: PublishSubject<MainIntent.RefreshIntent> = PublishSubject.create()


    //查询号码归属地的意图

    private val mCheckPhoneSubject: PublishSubject<MainIntent.CheckPhoneIntent> =
        PublishSubject.create()

    @Inject
    lateinit var mViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binds()
    }

    //数据绑定
    private fun binds() {

        //对数据状态改变进行监听
        mViewModel.states()
            .autoDispose(scopeProvider)
            .subscribe(this::render)

        //点击事件
        btn.clicks()
            //延迟一秒后没有再被触发数据才发射，如果不更改接收会在子线程中回调
            // .debounce(1,TimeUnit.SECONDS)
            //            .observeOn(AndroidSchedulers.mainThread())
            //直接触发，屏蔽掉1秒内的其他操作
            .throttleFirst(1, TimeUnit.SECONDS)
            .autoDispose(scopeProvider)
            .subscribe {
                //   showMessage("点击")
                ARouter.getInstance().build(RouterParty.Sub.SUB_ACTIVITY).navigation(this)
            }


      /*  btn_get_phone.visibility = View.GONE
        btn_get_phone.clicks()
            .throttleFirst(1, TimeUnit.SECONDS)
            .filter {
                return@filter TextUtils.isEmpty(et_phone.text.toString()).apply {
                    if (this) {
                        showMessage("请输入手机号")
                    }
                }
            }
            .map { MainIntent.CheckPhoneIntent(et_phone.text.toString()) }
            .autoDispose(scopeProvider)
            .subscribe(mCheckPhoneSubject)*/


        //观察意图
        mViewModel.processIntents(intents())
    }


    /**
     * 用户发起操作意图
     * @return Observable<MainIntent>
     */
    override fun intents(): Observable<MainIntent> {
        return Observable.mergeArray<MainIntent>(mRefreshIntent, mCheckPhoneSubject)
            .startWith(MainIntent.InitIntent)

    }

    /**
     * 逻辑处理之后返回数据操作ui
     * @param state MainViewState
     */
    override fun render(state: MainViewState) {

        showMessage("是否在加载中${state.isLoading}")

        when (state) {
            is MainViewState.ErrorState -> showMessage(state.error?.message)
            is MainViewState.SuccessState -> showMessage(state.data)

        }
    }


    private fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
