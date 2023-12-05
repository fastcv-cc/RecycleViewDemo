package com.application.demo.high.diffutil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

import java.util.ArrayList;
import java.util.List;

class DiffUtilAdapter extends RecyclerView.Adapter<DiffUtilAdapter.VH> {

    private ArrayList<String> mItems;

    public DiffUtilAdapter(ArrayList<String> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public DiffUtilAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_high_diff_util, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public void onBindViewHolder(@NonNull DiffUtilAdapter.VH holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}


