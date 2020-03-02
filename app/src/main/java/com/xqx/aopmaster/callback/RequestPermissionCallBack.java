package com.xqx.aopmaster.callback;

/**
 * Create by xuqunxing on  2020/3/2
 */
public interface RequestPermissionCallBack {
    /**
     * 同意授权
     */
    void granted();

    /**
     * 取消授权
     */
    void denied();
}
