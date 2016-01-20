package com.lesehome.sample.adapter.items;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.carrot.recycler.modularadapter.impl.HListItemAdapter;
import com.lesehome.sample.R;

import java.util.List;

/**
 * Created by hcp on 16/1/14.
 */
public class MainItem extends HListItemAdapter<List<String>> {

    private LayoutInflater inflater;

    public MainItem(Activity activity, int viewType) {
        super(viewType);
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<String> items, int position) {
        return items.get(position) instanceof String;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HViewHolder(inflater.inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<String> items, int position,
                                 @NonNull HViewHolder holder) {

        ((TextView) holder.itemView).setText(items.get(position));
    }

}
