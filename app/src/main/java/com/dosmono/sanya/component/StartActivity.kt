package com.dosmono.sanya.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.base.RouterParty
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btn.setOnClickListener {

            ARouter.getInstance().build(RouterParty.Main.MAIN_ACTIVITY).navigation();
        }

    }
}
