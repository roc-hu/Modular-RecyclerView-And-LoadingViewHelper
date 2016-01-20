package com.lesehome.carrot.recycler.modularadapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;

public abstract class AbsListAdapter<DATAS> extends RecyclerView.Adapter<HViewHolder> {

    protected AdapterManager<DATAS> adapterManager = new AdapterManager<>();
    protected IAdapterItem.OnItemClickListener onItemClickListener;
    protected IAdapterItem.OnItemLongClickListener onItemLongClickListener;

    protected DATAS items;

    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HViewHolder viewHolder = adapterManager.onCreateViewHolder(parent, viewType);
        viewHolder.setOnItemClickListener(getOnItemClickListener());
        viewHolder.setOnItemLongClickListener(getOnItemLongClickListener());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HViewHolder viewHolder, int position) {
        adapterManager.onBindViewHolder(items, position, viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
        return adapterManager.getItemViewType(items, position);
    }

    public DATAS getItems() {
        return items;
    }

    public void setItems(DATAS items) {
        this.items = items;
    }

    public IAdapterItem.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(IAdapterItem.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public IAdapterItem.OnItemLongClickListener getOnItemLongClickListener() {
        return onItemLongClickListener;
    }

    public void setOnItemLongClickListener(IAdapterItem.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
