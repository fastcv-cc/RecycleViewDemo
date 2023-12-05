package com.application.demo.base.grid;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

public class GridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        SwitchCompat sw = findViewById(R.id.sw);
        RecyclerView recyclerView = findViewById(R.id.rv);

        GridLayoutAdapter adapter = new GridLayoutAdapter();
        GridLayoutManager gridVerticalLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        GridLayoutManager gridHorizontalLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                recyclerView.setLayoutManager(gridHorizontalLayoutManager);
            } else {
                recyclerView.setLayoutManager(gridVerticalLayoutManager);
            }
            recyclerView.setAdapter(adapter);
        });

        recyclerView.setLayoutManager(gridVerticalLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
