package com.lesehome.sample.module_mvc.adapter.items;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.carrot.recycler.modularadapter.impl.HListItemAdapter;
import com.lesehome.sample.R;
import com.lesehome.sample.module_mvc.model.entity.Other;

import java.util.List;

/**
 * Created by hcp on 16/1/11.
 */
public class OtherItem extends HListItemAdapter<List<IItemEntity>> {

    private LayoutInflater inflater;

    public OtherItem(Activity activity, int viewType) {
        super(viewType);
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<IItemEntity> items, int position) {
        return items.get(position) instanceof Other;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HViewHolder(inflater.inflate(R.layout.item_example_mvc_other, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<IItemEntity> items, int position,
                                 @NonNull HViewHolder holder) {
        Other movie = (Other) items.get(position);
        if(movie !=null) {
            holder.setTag(movie);
            holder.getTv(R.id.item_otherMovie_description_textView).setText(String.valueOf(movie.getPrice()));
            holder.getTv(R.id.item_otherMovie_name_textView).setText(movie.getName());
            holder.getTv(R.id.item_otherMovie_time_textView).setText(movie.getTime());
        }
    }
}
