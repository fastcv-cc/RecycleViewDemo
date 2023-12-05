package com.application.demo.base.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

class GridLayoutAdapter extends RecyclerView.Adapter<GridLayoutAdapter.VH> {

    @NonNull
    @Override
    public GridLayoutAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridLayoutAdapter.VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridLayoutAdapter.VH holder, int position) {

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
