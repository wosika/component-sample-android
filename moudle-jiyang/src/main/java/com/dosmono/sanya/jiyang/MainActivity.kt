package com.dosmono.sanya.jiyang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.dosmono.sanya.basic.router.RouterParty

@Route(path = RouterParty.JIYANG_HOMEACTIVITY)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
