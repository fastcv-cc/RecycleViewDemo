package com.application.demo.high.itemtouchhelper;

import android.graphics.Canvas;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.application.demo.R;

public class MyItemTouchCallback extends ItemTouchHelper.Callback {

    private ItemTouchHelperAdapter mAdapter;

    public MyItemTouchCallback(ItemTouchHelperAdapter adapter) {
        mAdapter = adapter;
    }

    /**
     * 设置滑动类型标记
     *
     * @param recyclerView
     * @param viewHolder
     * @return 返回一个整数类型的标识，用于判断Item那种移动行为是允许的
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;  // 允许上下的拖动
        int swipeFlags = 0; // 不允许左右滑动
        return makeMovementFlags(dragFlags, swipeFlags);

        //int swipeFlags = ItemTouchHelper.LEFT;  // 只允许从右向左滑动
        //        return makeMovementFlags(dragFlags, swipeFlags);
    }

    /**
     * 拖拽切换 Item 的回调
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return true Item切换了位置，false Item没切换位置
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    /**
     * Item 是否支持长按拖动
     *
     * @return true  支持长按操作，false 不支持长按操作
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /**
     * Item 是否支持滑动
     *
     * @return true  支持滑动操作，false 不支持滑动操作
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    /**
     * Item被选中时候回调
     *
     * @param viewHolder
     * @param actionState 当前Item的状态
     *                    ItemTouchHelper.ACTION_STATE_IDLE   闲置状态
     *                    ItemTouchHelper.ACTION_STATE_SWIPE  滑动中状态
     *                    ItemTouchHelper#ACTION_STATE_DRAG   拖拽中状态
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        // item 被选中的操作
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundResource(R.drawable.drag_select_bg);
        } else {
            mAdapter.notifyDataSetChanged();
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 操作完毕后恢复颜色
        viewHolder.itemView.setBackgroundResource(0);
        super.clearView(recyclerView, viewHolder);
    }

    /**
     * 移动过程中重新绘制 Item，随着滑动的距离，设置 Item 的透明度
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        float x = Math.abs(dX) + 0.5f;
        float width = viewHolder.itemView.getWidth();
        float alpha = 1f - x / width;
        viewHolder.itemView.setAlpha(alpha);
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
