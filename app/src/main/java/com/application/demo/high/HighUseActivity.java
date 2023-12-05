package com.application.demo.high;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.demo.R;
import com.application.demo.base.BaseUseActivity;
import com.application.demo.base.grid.GridLayoutActivity;
import com.application.demo.base.horizontal.HorizontalLayoutActivity;
import com.application.demo.base.vertical.VerticalLayoutActivity;
import com.application.demo.base.waterfall.WaterfallLayoutActivity;
import com.application.demo.high.itemanimator.ItemAnimatorActivity;
import com.application.demo.high.itemdecoration.ItemDecorationActivity;
import com.application.demo.high.itemtouchhelper.ItemTouchHelperActivity;
import com.application.demo.high.snaphelper.SnapHelperActivity;

public class HighUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);

        findViewById(R.id.btItemAnimator).setOnClickListener(v -> startActivity(new Intent(HighUseActivity.this, ItemAnimatorActivity.class)));
        findViewById(R.id.btItemDecoration).setOnClickListener(v -> startActivity(new Intent(HighUseActivity.this, ItemDecorationActivity.class)));
        findViewById(R.id.btItemTouchHelper).setOnClickListener(v -> startActivity(new Intent(HighUseActivity.this, ItemTouchHelperActivity.class)));
        findViewById(R.id.btSnapHelper).setOnClickListener(v -> startActivity(new Intent(HighUseActivity.this, SnapHelperActivity.class)));
    }
}
