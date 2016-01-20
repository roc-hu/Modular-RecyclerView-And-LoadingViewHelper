package com.lesehome.sample.module_list.adapter;

import android.app.Activity;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HListAdapter;
import com.lesehome.sample.module_list.adapter.item.DogItem;
import com.lesehome.sample.module_list.adapter.item.GeckoItem;
import com.lesehome.sample.module_list.adapter.item.SnakeItem;

import java.util.List;


public class LinearAdapter extends HListAdapter<List<IItemEntity>>  {

    public LinearAdapter(Activity activity, List<IItemEntity> items) {
        // Delegates
        this.adapterManager.add(new GeckoItem(activity, 0));
        this.adapterManager.add(new SnakeItem(activity, 1));
        this.adapterManager.add(new DogItem(activity, 2));
        setItems(items);
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(int position, IItemEntity item) {
        items.add(position, item);
        notifyItemInserted(position); //Attention!
    }
}
