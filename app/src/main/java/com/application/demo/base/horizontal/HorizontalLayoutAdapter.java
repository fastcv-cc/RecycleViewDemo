package com.application.demo.base.horizontal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

class HorizontalLayoutAdapter extends RecyclerView.Adapter<HorizontalLayoutAdapter.VH> {

    @NonNull
    @Override
    public HorizontalLayoutAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_horizontal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalLayoutAdapter.VH holder, int position) {

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


