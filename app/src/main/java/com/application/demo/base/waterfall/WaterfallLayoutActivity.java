package com.application.demo.base.waterfall;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.application.demo.R;

public class WaterfallLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall_layout);

        SwitchCompat sw = findViewById(R.id.sw);
        RecyclerView recyclerView = findViewById(R.id.rv);

        WaterfallLayoutAdapter adapter = new WaterfallLayoutAdapter();
        StaggeredGridLayoutManager staggeredGridVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        StaggeredGridLayoutManager staggeredGridHorizontalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);

        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                recyclerView.setLayoutManager(staggeredGridHorizontalLayoutManager);
            } else {
                recyclerView.setLayoutManager(staggeredGridVerticalLayoutManager);
            }
            recyclerView.setAdapter(adapter);
        });

        recyclerView.setLayoutManager(staggeredGridVerticalLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
