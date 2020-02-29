package com.xqx.aopmaster.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;


/**
 * 消息处理工具类
 */
public class MessageUtils {


    private static Toast mToast;

    public static void show(Context context, final String text) {
        show(context, text, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, final int resId) {
        show(context, context.getString(resId), Toast.LENGTH_SHORT);
    }

    public static void show(Context context, CharSequence text, int duration) {
        if (TextUtils.isEmpty(text) || "OK".equals(text)) {
            return;
        }
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, text, duration);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    public static void show(Context context, CharSequence text, int duration, int GravityInt) {
        if (TextUtils.isEmpty(text) || "OK".equals(text)) {
            return;
        }
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, text, duration);
        mToast.setGravity(GravityInt, 0, 0);
        mToast.show();
    }

}
