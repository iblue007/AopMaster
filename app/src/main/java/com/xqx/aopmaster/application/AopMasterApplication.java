package com.xqx.aopmaster.application;

import android.app.Application;
import android.os.Handler;

import com.xqx.aopmaster.aop.timelog.TimeLog;
import com.xqx.aopmaster.config.Global;
import com.xqx.aopmaster.util.LogUtils;

/**
 * Create by xuqunxing on  2020/2/29
 */
public class AopMasterApplication extends Application {

    @TimeLog
    @Override
    public void onCreate() {
        super.onCreate();
        Global.setContext(getApplicationContext());
        Global.setHandler(new Handler());
        LogUtils.e("======","======222222222222222");
    }
}
