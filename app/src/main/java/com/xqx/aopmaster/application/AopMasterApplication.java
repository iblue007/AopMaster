package com.xqx.aopmaster.application;

import android.app.Application;
import android.os.Handler;

import com.xqx.aopmaster.config.Global;

/**
 * Create by xuqunxing on  2020/2/29
 */
public class AopMasterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Global.setContext(getApplicationContext());
        Global.setHandler(new Handler());
    }
}
