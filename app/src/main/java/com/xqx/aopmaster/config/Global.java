package com.xqx.aopmaster.config;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;

/**
 * Create by xuqunxing on  2019/3/8
 */
public class Global {
    private static Handler handler;
    private static Context context;
    public static final String TAG = "Global_Videopaper";

    public Global() {
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        if (handler == null) {
            Class var0 = Global.class;
            synchronized(Global.class) {
                if (handler == null) {
                    handler = new Handler(Looper.getMainLooper());
                }
            }
        }

        return handler;
    }

    public static void setContext(Context context1) {
        context = context1;
    }

    public static void setHandler(Handler handler1) {
        handler = handler1;
    }

    public static String getPkgName() {
        return context.getPackageName();
    }

    public static Context getApplicationContext() {
        return context.getApplicationContext();
    }

    public static Resources getResource() {
        return context.getResources();
    }

    public static void runInMainThread(Runnable task) {
        if (task != null) {
            Handler mainHandler = getHandler();
            if (mainHandler != null) {
                mainHandler.post(task);
            }
        }else {
            Handler mainHandler = getHandler();
            if (mainHandler != null) {
                mainHandler.removeCallbacksAndMessages(null);
            }
        }
    }

    public static void runInMainThread(Runnable task, int delay) {
        if (task != null) {
            Handler mainHandler = getHandler();
            if (mainHandler != null) {
                mainHandler.postDelayed(task, (long)delay);
            }
        }else {
            Handler mainHandler = getHandler();
            if (mainHandler != null) {
                mainHandler.removeCallbacksAndMessages(null);
            }
        }

    }
}
