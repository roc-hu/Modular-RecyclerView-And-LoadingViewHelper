package com.lesehome.carrot.recycler.modularadapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;

public interface IAdapterItem<DATAS> {

    int getItemViewType();

    boolean isForViewType(@NonNull DATAS items, int position);

    @NonNull
    HViewHolder onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(@NonNull DATAS items, int position, @NonNull HViewHolder holder);


    interface OnItemClickListener {
        void onItemClick(View view, int position, int itemViewType);
    }
    interface OnItemLongClickListener {
        boolean onItemLongClick(View view, int position, int itemViewType);
    }
}
