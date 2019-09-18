package com.dosmono.sanya.jiyang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.dosmono.sanya.basic.router.RouterParty
import com.dosmono.sanya.tianya.R

@Route(path = RouterParty.TIANYA_HOMEACTIVITY)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
