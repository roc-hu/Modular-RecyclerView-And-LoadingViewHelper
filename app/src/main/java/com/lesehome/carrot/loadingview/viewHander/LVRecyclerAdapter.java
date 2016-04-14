package com.lesehome.carrot.loadingview.viewHander;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

public class LVRecyclerAdapter extends LVAdapter {

    private Adapter adapter;

    public LVRecyclerAdapter(Adapter adapter) {
        super();
        this.adapter = adapter;
        this.adapter.registerAdapterDataObserver(adapterDataObserver);
    }

    private AdapterDataObserver adapterDataObserver = new AdapterDataObserver() {

        public void onChanged() {
            LVRecyclerAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int positionStart, int itemCount) {
            LVRecyclerAdapter.this.notifyItemRangeChanged(positionStart, itemCount);
        }

        public void onItemRangeInserted(int positionStart, int itemCount) {
            LVRecyclerAdapter.this.notifyItemRangeInserted(positionStart, itemCount);
        }

        public void onItemRangeRemoved(int positionStart, int itemCount) {
            LVRecyclerAdapter.this.notifyItemRangeRemoved(positionStart, itemCount);
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            LVRecyclerAdapter.this.notifyItemMoved(fromPosition, toPosition);
        }

    };

    @Override
    public ViewHolder onCreateViewHolderHF(ViewGroup viewGroup, int type) {
        return adapter.onCreateViewHolder(viewGroup, type);
    }

    @Override
    public void onBindViewHolderHF(ViewHolder vh, int position) {
        adapter.onBindViewHolder(vh, position);
    }

    @Override
    public int getItemCountHF() {
        return adapter.getItemCount();
    }

    @Override
    public int getItemViewTypeHF(int position) {
        return adapter.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return adapter.getItemId(position);
    }

}
