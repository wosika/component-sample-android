package com.dosmono.sanya.talk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dosmono.sanya.component.base.RouterParty;

@Route(path = RouterParty.Talk.TALK_ACTIVITY)
public class TalkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk_activity_talk);
    }
}
