package com.dosmono.sanya.mvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.base.RouterParty
import com.dosmono.sanya.main.R
import com.dosmono.sanya.mvi.view.IView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.main_activity_main.*

@Route(path = RouterParty.Main.MAIN_ACTIVITY)
class MainActivity : AppCompatActivity(),IView<MainIntent,MainViewState> {


    /**
     * 用户发起操作意图
     * @return Observable<MainIntent>
     */
    override fun intents(): Observable<MainIntent> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 逻辑处理之后返回数据操作ui
     * @param state MainViewState
     */
    override fun render(state: MainViewState) {

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)

        btn.setOnClickListener {
            ARouter.getInstance().build(RouterParty.Sub.SUB_ACTIVITY).navigation();
        }


        NetworkUtils.getPhoneState(this)
    }
}
