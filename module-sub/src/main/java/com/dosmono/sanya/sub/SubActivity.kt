package com.dosmono.sanya.sub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.component.RouterParty
import kotlinx.android.synthetic.main.sub_activity_sub.*

@Route(path = RouterParty.Sub.SUB_ACTIVITY)
class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sub_activity_sub)

        btn.setOnClickListener {
            ARouter.getInstance().build(RouterParty.Talk.TALK_ACTIVITY).navigation(this)
        }
    }
}
