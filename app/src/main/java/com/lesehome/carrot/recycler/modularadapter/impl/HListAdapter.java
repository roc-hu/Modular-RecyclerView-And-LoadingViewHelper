package com.lesehome.carrot.recycler.modularadapter.impl;

import com.lesehome.carrot.recycler.modularadapter.AbsListAdapter;

import java.util.List;


public class HListAdapter<DATAS extends List<?>> extends AbsListAdapter<DATAS> {

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
