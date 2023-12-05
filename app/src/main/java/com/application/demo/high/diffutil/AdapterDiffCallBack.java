package com.application.demo.high.diffutil;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

public class AdapterDiffCallBack extends DiffUtil.Callback {

    private ArrayList<String> mOldList;
    private ArrayList<String> mNewList;

    public AdapterDiffCallBack(ArrayList<String> oldList,ArrayList<String> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        boolean b = mNewList.get(newItemPosition) == mOldList.get(oldItemPosition);
        return b;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        boolean equals = mNewList.get(newItemPosition).equals(mOldList.get(oldItemPosition));
        return equals;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        //如果areItemsTheSame 返回true 但是areContentsTheSame返回false 就会走这个方法
        //然后就会走到Adapter的onBindViewHolder(@NonNull VH holder, int position, @NonNull List<Object> payloads)方法
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
