package com.dosmono.sanya.sub.mvi

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.architecture.di.AppComponent
import com.dosmono.sanya.architecture.mvi.view.activity.BaseActivity
import com.dosmono.sanya.component.RouterParty
import com.dosmono.sanya.sub.R
import com.dosmono.sanya.sub.di.DaggerSubActivityComponent
import io.reactivex.Observable
import kotlinx.android.synthetic.main.sub_activity_sub.*
import javax.inject.Inject

@Route(path = RouterParty.Sub.SUB_ACTIVITY)
class SubActivity : BaseActivity<SubIntent, SubViewState>() {


    @Inject
    lateinit var mViewModel: SubViewModel

    override val layoutId: Int
        get() = R.layout.sub_activity_sub

    override fun intents(): Observable<SubIntent> {
     return Observable.empty()
    }

    override fun render(state: SubViewState) {

    }

    override fun daggerInject(appComponent: AppComponent) {
        DaggerSubActivityComponent.builder().activity(this).appComponent(appComponent).build().inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn.setOnClickListener {
            ARouter.getInstance().build(RouterParty.Talk.TALK_ACTIVITY).navigation(this)
        }

        mViewModel.processIntents(intents())


    }
}
