package com.application.demo.high.itemanimator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

import java.util.ArrayList;

class ItemAnimatorAdapter extends RecyclerView.Adapter<ItemAnimatorAdapter.VH> {
    private final ArrayList<String> datas = new ArrayList<>();

    public void addItem() {
        addItem(datas.size());
    }

    private void addItem(int index) {
        datas.add(index, "");
        notifyItemInserted(index);
        notifyItemRangeChanged(index, datas.size() - index);
    }

    private void removeItem(int index) {
        datas.remove(index);
        notifyItemRemoved(index);
        notifyItemChanged(index);
        notifyItemRangeChanged(index, datas.size() - index);
    }

    @NonNull
    @Override
    public ItemAnimatorAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_high_animator, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAnimatorAdapter.VH holder, int position) {
        holder.itemView.setOnClickListener(v -> addItem(position));
        holder.itemView.setOnLongClickListener(v -> {
            removeItem(position);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}


