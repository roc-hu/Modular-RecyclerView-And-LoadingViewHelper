package com.lesehome.carrot.recycler.modularadapter.impl;


import com.lesehome.carrot.recycler.modularadapter.IAdapterItem;

public abstract class HListItemAdapter<DATAS> implements IAdapterItem<DATAS> {

    protected int viewType;

    public HListItemAdapter(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public int getItemViewType() {
        return viewType;
    }
}
