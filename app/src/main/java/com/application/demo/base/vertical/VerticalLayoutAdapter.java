package com.application.demo.base.vertical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

class VerticalLayoutAdapter extends RecyclerView.Adapter<VerticalLayoutAdapter.VH> {

    @NonNull
    @Override
    public VerticalLayoutAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_vertical, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalLayoutAdapter.VH holder, int position) {

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


