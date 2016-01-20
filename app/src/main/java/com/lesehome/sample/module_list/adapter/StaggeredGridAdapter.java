package com.lesehome.sample.module_list.adapter;

import android.app.Activity;

import com.lesehome.carrot.recycler.modularadapter.AdapterManager;
import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HListAdapter;
import com.lesehome.sample.module_list.adapter.item.AdvertisementItem;
import com.lesehome.sample.module_list.adapter.item.CatItem;
import com.lesehome.sample.module_list.adapter.item.DogItem;
import com.lesehome.sample.module_list.adapter.item.GeckoItem;
import com.lesehome.sample.module_list.adapter.item.SnakeItem;

import java.util.List;


public class StaggeredGridAdapter extends HListAdapter<List<IItemEntity>> {

    public StaggeredGridAdapter(Activity activity, List<IItemEntity> list) {
        adapterManager = new AdapterManager<>();
        adapterManager.add(new CatItem(activity, 0));
        adapterManager.add(new AdvertisementItem(activity, 1));
        adapterManager.add(new DogItem(activity, 2));
        adapterManager.add(new GeckoItem(activity, 3));
        adapterManager.add(new SnakeItem(activity, 4));

        setItems(list);
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
