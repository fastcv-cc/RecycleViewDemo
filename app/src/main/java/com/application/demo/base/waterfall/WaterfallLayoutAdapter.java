package com.application.demo.base.waterfall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

class WaterfallLayoutAdapter extends RecyclerView.Adapter<WaterfallLayoutAdapter.VH> {

    private int[] intArr = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 2, 4, 6, 1, 3, 5, 6, 8, 1, 4, 7, 3, 10, 6, 3, 4, 7, 2, 7, 2, 8, 4, 2, 8, 3, 7, 10, 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 2, 4, 6, 1, 3, 5, 6, 8, 1, 4, 7, 3, 10, 6, 3, 4, 7, 2, 7, 2, 8, 4, 2, 8, 3, 7, 10};

    @NonNull
    @Override
    public WaterfallLayoutAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WaterfallLayoutAdapter.VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_waterfall, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return intArr[position];
    }

    @Override
    public void onBindViewHolder(@NonNull WaterfallLayoutAdapter.VH holder, int position) {
        String s = "我是一段文本";
        StringBuilder text = new StringBuilder(s);
        for (int i = 0; i < intArr[position]; i++) {
            text.append(s);
        }
        holder.tv.setText(text.toString());
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class VH extends RecyclerView.ViewHolder {

        private final TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
