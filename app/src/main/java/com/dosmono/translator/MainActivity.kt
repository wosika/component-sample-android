package com.dosmono.translator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dosmono.sanya.basic.router.RouterParty
import kotlinx.android.synthetic.main.activity_main.*
@Route(path = RouterParty.APP_MAINACTIVITY)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            ARouter.getInstance().build(RouterParty.TIANYA_HOMEACTIVITY).navigation();
        }
    }
}
