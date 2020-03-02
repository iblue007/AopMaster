package com.xqx.aopmaster.ui;

import com.xqx.aopmaster.callback.RequestPermissionCallBack;
import com.xqx.aopmaster.util.LogUtils;
import com.xqx.aopmaster.util.RequestPermissionUtil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Create by xuqunxing on  2020/3/2
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LogUtils.e("======", "======requestCode:" + requestCode + "----grantResults:" + grantResults.toString());
        if (requestCode == RequestPermissionUtil.mRequestCode) {
            RequestPermissionUtil.requestPermissions(this, permissions, new RequestPermissionCallBack() {
                @Override
                public void granted() {
                    requestPermissionTest();
                }

                @Override
                public void denied() {

                }
            });
        }
    }

    protected void requestPermissionTest() {

    }
}
