package com.application.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.application.demo.base.BaseUseActivity;
import com.application.demo.high.HighUseActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btBase).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BaseUseActivity.class)));
        findViewById(R.id.btHigh).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HighUseActivity.class)));
    }

}