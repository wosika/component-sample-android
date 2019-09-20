package com.dosmono.sanya.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.base.RouterParty
import com.dosmono.sanya.main.R
import kotlinx.android.synthetic.main.main_activity_main.*

@Route(path = RouterParty.Main.MAIN_ACTIVITY)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)


        btn.setOnClickListener {
            ARouter.getInstance().build(RouterParty.Sub.SUB_ACTIVITY).navigation();
        }

    }
}
