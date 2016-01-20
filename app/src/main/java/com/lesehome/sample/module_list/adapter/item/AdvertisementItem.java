package com.lesehome.sample.module_list.adapter.item;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.carrot.recycler.modularadapter.impl.HListItemAdapter;
import com.lesehome.sample.model.entity.Advertisement;
import com.lesehome.sample.R;

import java.util.List;


public class AdvertisementItem extends HListItemAdapter<List<IItemEntity>> {

    LayoutInflater inflater;

    public AdvertisementItem(Activity activity, int viewType) {
        super(viewType);
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<IItemEntity> items, int position) {
        return items.get(position) instanceof Advertisement;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HViewHolder(inflater.inflate(R.layout.sample_item_advertisement, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<IItemEntity> items, int position, @NonNull HViewHolder holder) {

    }
}
