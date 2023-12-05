package com.application.demo.high.snaphelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

import java.util.ArrayList;

class SnapHelperAdapter extends RecyclerView.Adapter<SnapHelperAdapter.VH> {

    private final ArrayList<Integer> images = new ArrayList<>();

    public SnapHelperAdapter() {
        images.add(R.mipmap.hero1);
        images.add(R.mipmap.hero2);
        images.add(R.mipmap.hero3);
        images.add(R.mipmap.hero4);
        images.add(R.mipmap.hero5);
        images.add(R.mipmap.hero6);
        images.add(R.mipmap.hero7);
        images.add(R.mipmap.hero8);
        images.add(R.mipmap.hero9);
        images.add(R.mipmap.hero10);
        images.add(R.mipmap.hero11);
        images.add(R.mipmap.hero12);
        images.add(R.mipmap.hero13);
        images.add(R.mipmap.hero14);
        images.add(R.mipmap.hero15);
        images.add(R.mipmap.hero16);
        images.add(R.mipmap.hero17);
        images.add(R.mipmap.hero18);
        images.add(R.mipmap.hero19);
        images.add(R.mipmap.hero20);
    }

    @NonNull
    @Override
    public SnapHelperAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_high_snap_helper, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SnapHelperAdapter.VH holder, int position) {
        holder.iv.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        public ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}


