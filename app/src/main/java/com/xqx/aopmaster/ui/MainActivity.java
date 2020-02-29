package com.xqx.aopmaster.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xqx.aopmaster.aop.checkLogin.CheckLoginImpl;
import com.xqx.aopmaster.aop.singleclick.MyAnnatation;
import com.xqx.aopmaster.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView loginTest;
    private TextView clickTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginTest = findViewById(R.id.login_test_tv);
        clickTest = findViewById(R.id.click_test_tv);
        clickTest.setOnClickListener(this);
        loginTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == clickTest) {
            clickTest();
        } else if (v == loginTest) {
            loginTest();
        }
    }

    @MyAnnatation(clickIntervals = 800)
    private void clickTest() {
        Log.e("======", "======click");
    }

    @CheckLoginImpl
    private void loginTest() {
        Log.e("======", "====== loginTest");
    }
}
