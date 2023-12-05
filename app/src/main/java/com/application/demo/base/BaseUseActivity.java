package com.application.demo.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.demo.R;
import com.application.demo.base.grid.GridLayoutActivity;
import com.application.demo.base.horizontal.HorizontalLayoutActivity;
import com.application.demo.base.vertical.VerticalLayoutActivity;

public class BaseUseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        findViewById(R.id.btVertical).setOnClickListener(v -> startActivity(new Intent(BaseUseActivity.this, VerticalLayoutActivity.class)));
        findViewById(R.id.btHorizontal).setOnClickListener(v -> startActivity(new Intent(BaseUseActivity.this, HorizontalLayoutActivity.class)));
        findViewById(R.id.btGrid).setOnClickListener(v -> startActivity(new Intent(BaseUseActivity.this, GridLayoutActivity.class)));
        findViewById(R.id.btWaterfall).setOnClickListener(v -> startActivity(new Intent(BaseUseActivity.this, VerticalLayoutActivity.class)));

    }
}
