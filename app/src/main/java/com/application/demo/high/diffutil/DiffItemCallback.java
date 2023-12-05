package com.application.demo.high.diffutil;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class DiffItemCallback extends DiffUtil.ItemCallback<String> {
    @Override
    public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        return oldItem.equals(newItem);
    }
}
