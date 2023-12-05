package com.application.demo.high.itemdecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

class ItemDecorationAdapter extends RecyclerView.Adapter<ItemDecorationAdapter.VH> {

    @NonNull
    @Override
    public ItemDecorationAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_high_decoration, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDecorationAdapter.VH holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}


