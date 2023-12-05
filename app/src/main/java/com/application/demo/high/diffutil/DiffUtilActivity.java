package com.application.demo.high.diffutil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

import java.util.ArrayList;
import java.util.Random;

public class DiffUtilActivity extends AppCompatActivity {

    private ArrayList<String> items = new ArrayList<>();

    private Handler handler = new Handler(Looper.getMainLooper());
    private DiffUtilAdapter adapter;

    private Runnable refresh = () -> refreshItem();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_util);

        RecyclerView recyclerView = findViewById(R.id.rv);

        adapter = new DiffUtilAdapter(items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);



        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        refreshItem();
    }

    private void refreshItem() {
        ArrayList<String> newItem = buildItems();
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new AdapterDiffCallBack(items, newItem), true);
        diffResult.dispatchUpdatesTo(adapter);
        items.clear();
        items.addAll(newItem);
        handler.postDelayed(refresh ,1000);
    }

    private ArrayList<String> buildItems() {
        ArrayList<String> tempItems = new ArrayList<>();
        int nextInt = new Random().nextInt(10);
        for (int i = 0; i < nextInt; i++) {
            tempItems.add("");
        }
        return tempItems;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(refresh);
    }
}
