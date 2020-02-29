package com.xqx.aopmaster;

import android.util.Log;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Calendar;

/**
 * Create by xuqunxing on  2020/2/29
 */
@Aspect
public class SingleClickAop {

    static final String TAG = SingleClickAop.class.getName();
    static final int KEY = R.id.testTv;

    @Pointcut("execution(@ com.xqx.aopmaster.MyAnnatation * *(..))")
    public void executionSingleClick() {

    }

    @Around("executionSingleClick() && @annotation(singleClick)")
    public void executionSingleClickAround(ProceedingJoinPoint joinPoint, MyAnnatation singleClick) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        SingleClick singleClick = methodSignature.getMethod().getAnnotation(SingleClick.class);
//        singleClick.clickIntervals();
        View view = null;
        for (Object o : joinPoint.getArgs()) {
            if (o instanceof View) {
                view = (View) o;
            }
        }
        Log.e("======", "======singleClick:" + singleClick);
        if (view != null) {
            Object tag = view.getTag(KEY);
            long lastClickTime = tag == null ? 0 : (long) tag;
            Log.d(TAG, "executionSingleClickAround: lastClickTime  " + lastClickTime + "   clickIntervals  " + singleClick.clickIntervals());
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (currentTime - lastClickTime >= singleClick.clickIntervals()) {
                view.setTag(KEY, currentTime);
                Log.d(TAG, "executionSingleClickAround: currentTime  " + currentTime);
                joinPoint.proceed();
            }
        }
        Log.e("======", "======singleClick22222:" + joinPoint.toShortString() + "--" + singleClick.clickIntervals());
    }
}