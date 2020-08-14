package com.licheedev.somelibrary;

import android.app.Application;
import com.licheedev.myutils.SpUtil;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println(SpUtil.getDefault().getInt("aaaa",0));
    }
}
