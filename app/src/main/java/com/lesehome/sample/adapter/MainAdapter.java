package com.lesehome.sample.adapter;

import android.app.Activity;

import com.lesehome.carrot.recycler.modularadapter.impl.HListAdapter;
import com.lesehome.sample.adapter.items.MainItem;

import java.util.List;

/**
 * Created by hcp on 16/1/14.
 */
public class MainAdapter extends HListAdapter<List<String>> {


    public MainAdapter(Activity activity, List<String> strings) {
        this.adapterManager.add(new MainItem(activity, 0));
        this.setItems(strings);
    }
}
