package com.xqx.aopmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView testTv = findViewById(R.id.testTv);
        testTv.setOnClickListener(this);
    }


    @MyAnnatation(clickIntervals = 800)
    @Override
    public void onClick(View v) {
        Log.e("======", "======click");
    }
}
