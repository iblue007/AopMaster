package com.xqx.aopmaster.aop.timelog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by xuqunxing on  2020/3/20
 * 打印方法耗时Log注解，通过aop切片的方式在编译期间织入源代码中
 * 功能：自动打印方法的耗时
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface TimeLog {
}
