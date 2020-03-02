package com.xqx.aopmaster.ui;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.xqx.aopmaster.aop.checkLogin.CheckLoginImpl;
import com.xqx.aopmaster.aop.permission.NeedPermission;
import com.xqx.aopmaster.aop.singleclick.MyAnnatation;
import com.xqx.aopmaster.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView loginTest;
    private TextView clickTest;
    private TextView reqeustPemissionTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginTest = findViewById(R.id.login_test_tv);
        clickTest = findViewById(R.id.click_test_tv);
        reqeustPemissionTest = findViewById(R.id.login_permission_tv);
        clickTest.setOnClickListener(this);
        loginTest.setOnClickListener(this);
        reqeustPemissionTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == clickTest) {
            clickTest(v);
        } else if (v == loginTest) {
            loginTest(v);
        } else if (v == reqeustPemissionTest) {
            requestPermissionTest();
        }
    }

    @NeedPermission({Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE})
    @Override
    protected void requestPermissionTest() {
        super.requestPermissionTest();
        Log.e("======", "======requestPermissionTest");
    }

    @MyAnnatation(clickIntervals = 800)
    public void clickTest(View v) {
        Log.e("======", "======click");
    }

    @CheckLoginImpl
    public void loginTest(View v) {
        Log.e("======", "====== loginTest");
    }

}
