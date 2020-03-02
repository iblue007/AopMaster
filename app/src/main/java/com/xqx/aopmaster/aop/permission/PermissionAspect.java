package com.xqx.aopmaster.aop.permission;

import android.app.Fragment;
import android.content.Context;

import com.xqx.aopmaster.callback.RequestPermissionCallBack;
import com.xqx.aopmaster.util.LogUtils;
import com.xqx.aopmaster.util.RequestPermissionUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Create by xuqunxing on  2020/3/2
 */
@Aspect
public class PermissionAspect {

    private static final String PERMISSION_REQUEST_POINTCUT =
            "execution(@com.xqx.aopmaster.aop.permission.NeedPermission * *(..))";

    @Pointcut(PERMISSION_REQUEST_POINTCUT + " && @annotation(needPermission)")
    public void requestPermissionMethod(NeedPermission needPermission) {
    }

    @Around("requestPermissionMethod(needPermission)")
    public void AroundJoinPoint(final ProceedingJoinPoint joinPoint, NeedPermission needPermission) {

        Context context = null;
        final Object object = joinPoint.getThis();
    //    LogUtils.e("======", "======" + object.toString());
        if (object instanceof Context) {
            context = (Context) object;
        } else if (object instanceof Fragment) {
            context = ((Fragment) object).getActivity();
        }
        if (context == null || needPermission == null) return;
     //   LogUtils.e("======", "======" + needPermission.toString());
        RequestPermissionUtil.requestPermissions(context, needPermission.value(), new RequestPermissionCallBack() {
            @Override
            public void granted() {
                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }

            @Override
            public void denied() {

            }
        });
    }
}