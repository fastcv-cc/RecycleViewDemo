package com.application.demo.high.itemtouchhelper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

import java.util.ArrayList;

class ItemTouchHelperAdapter extends RecyclerView.Adapter<ItemTouchHelperAdapter.VH> {

    private static final String TAG = "ItemTouchHelperAdapter";

    private final ArrayList<String> stringData = new ArrayList<>();

    public ItemTouchHelperAdapter() {
        for (int i = 0; i < 30; i++) {
            stringData.add("这是一段文本" + i);
        }
    }

    @NonNull
    @Override
    public ItemTouchHelperAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_high_touch_helper, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTouchHelperAdapter.VH holder, int position) {
        holder.tv.setText(stringData.get(position));
    }

    public void onItemMove(int fromPosition, int toPosition) {
        Log.d(TAG, "onItemMove: fromPosition = " + fromPosition + " toPosition = " + toPosition);
        String prev = stringData.remove(fromPosition);
        Log.d(TAG, "onItemMove: ------------------------");
        for (String s : stringData) {
            Log.d(TAG, "onItemMove: " + s);
        }
        Log.d(TAG, "onItemMove: ------------------------");
        stringData.add(toPosition, prev);
        for (String s : stringData) {
            Log.d(TAG, "onItemMove: " + s);
        }
        Log.d(TAG, "onItemMove: ------------------------");
        notifyItemMoved(fromPosition, toPosition);
//        notifyDataSetChanged();
        for (String s : stringData) {
            Log.d(TAG, "onItemMove: " + s);
        }
    }

    public void onItemDismiss(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        stringData.remove(position);
        notifyItemRemoved(position);

        // 解决 RecyclerView 删除 Item 导致位置错乱的问题
        if (position != stringData.size()) {
            notifyItemRangeChanged(position, stringData.size() - position);
        }
    }

    @Override
    public int getItemCount() {
        return stringData.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        public TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}


