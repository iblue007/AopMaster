package com.xqx.aopmaster.aop.checkLogin;

import android.text.TextUtils;
import android.view.View;

import com.xqx.aopmaster.config.BaseConfigPreferences;
import com.xqx.aopmaster.config.Global;
import com.xqx.aopmaster.util.MessageUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Create by xuqunxing on  2020/2/29
 */
@Aspect
public class CheckLoginAop {

    @Pointcut("execution(@com.xqx.aopmaster.aop.checkLogin.CheckLoginImpl * *(..))")//方法切入点
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        if (TextUtils.isEmpty(BaseConfigPreferences.getInstance(Global.getContext()).getLoginAccount())) {
            MessageUtils.show(Global.getContext(), "账号未登录");
            BaseConfigPreferences.getInstance(Global.getContext()).setLoginAccount("111111");
            return;
        }
        joinPoint.proceed();//执行原方法
    }

}
