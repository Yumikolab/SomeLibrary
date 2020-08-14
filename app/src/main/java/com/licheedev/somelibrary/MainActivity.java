package com.licheedev.somelibrary;

import android.os.Bundle;
import com.licheedev.base.CommonRx3Activity;

public class MainActivity extends CommonRx3Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTranslucentStatus();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
