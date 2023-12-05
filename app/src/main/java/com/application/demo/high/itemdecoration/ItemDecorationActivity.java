package com.application.demo.high.itemdecoration;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

public class ItemDecorationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);

        RecyclerView recyclerView = findViewById(R.id.rv);
        SwitchCompat sw = findViewById(R.id.sw);

        ItemDecorationAdapter adapter = new ItemDecorationAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        MyItemDecoration myItemDecoration = new MyItemDecoration(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                recyclerView.addItemDecoration(myItemDecoration);
            } else {
                recyclerView.removeItemDecoration(myItemDecoration);
            }
        });
    }
}
