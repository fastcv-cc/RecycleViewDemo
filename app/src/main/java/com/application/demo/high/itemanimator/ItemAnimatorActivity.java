package com.application.demo.high.itemanimator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

public class ItemAnimatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_animator);

        RecyclerView recyclerView = findViewById(R.id.rv);
        TextView tv = findViewById(R.id.tv);

        ItemAnimatorAdapter adapter = new ItemAnimatorAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        tv.setOnClickListener(v -> adapter.addItem());
    }
}
