package com.lesehome.sample.module_mvc.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import com.lesehome.carrot.recycler.modularadapter.AdapterManager;
import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.loadingview.IDataAdapter;
import com.lesehome.carrot.loadingview.data.Data3;
import com.lesehome.carrot.recycler.modularadapter.impl.HListAdapter;
import com.lesehome.sample.module_mvc.model.entity.Discuss;
import com.lesehome.sample.module_mvc.model.entity.Movie;
import com.lesehome.sample.module_mvc.adapter.items.DiscussItem;
import com.lesehome.sample.module_mvc.adapter.items.MovieItem;
import com.lesehome.sample.module_mvc.adapter.items.OtherItem;
import com.lesehome.sample.module_mvc.model.entity.Other;

public class MovieDetailAdapter extends HListAdapter<List<IItemEntity>> implements
        IDataAdapter<Data3<Movie, List<Discuss>, List<Other>>> {


    private Data3<Movie, List<Discuss>, List<Other>> mData = new Data3<Movie, List<Discuss>, List<Other>>(null, new ArrayList<Discuss>(),
            new ArrayList<Other>());

    public MovieDetailAdapter(Activity activity) {
        adapterManager = new AdapterManager<>();
        adapterManager.add(new MovieItem(activity, 0));
        adapterManager.add(new DiscussItem(activity, 1));
        adapterManager.add(new OtherItem(activity, 2));
        setItems(new ArrayList<IItemEntity>());
    }

    @Override
    public void notifyDataChanged(Data3<Movie, List<Discuss>, List<Other>> data, boolean isRefresh) {
        items.clear();
        if (isRefresh) {
            mData.setValue1(data.getValue1());
            mData.getValue2().clear();
            mData.getValue3().clear();
        }
        if (data.getValue2() != null) {
            mData.getValue2().addAll(data.getValue2());
        }
        if (data.getValue3() != null) {
            mData.getValue3().addAll(data.getValue3());
        }

        items.add(mData.getValue1());
        items.addAll(mData.getValue2());
        items.addAll(mData.getValue3());
        notifyDataSetChanged();
    }

    @Override
    public Data3<Movie, List<Discuss>, List<Other>> getData() {
        return mData;
    }

    @Override
    public boolean isEmpty() {
        return mData.getValue1() == null;
    }

}
