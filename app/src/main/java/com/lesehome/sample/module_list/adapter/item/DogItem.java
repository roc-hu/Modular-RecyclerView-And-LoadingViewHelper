package com.lesehome.sample.module_list.adapter.item;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HListItemAdapter;
import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.sample.model.entity.Dog;
import com.lesehome.sample.R;

import java.util.List;

public class DogItem extends HListItemAdapter<List<IItemEntity>> {

    private LayoutInflater inflater;

    public DogItem(Activity activity, int viewType) {
        super(viewType);
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<IItemEntity> items, int position) {
        return items.get(position) instanceof Dog;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HViewHolder(inflater.inflate(R.layout.sample_item_dog, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<IItemEntity> items, int position,
                                 @NonNull HViewHolder holder) {

        Dog dog = (Dog) items.get(position);
        holder.setTag(dog);
        holder.getTv(R.id.name).setText(dog.getName());
    }
}
