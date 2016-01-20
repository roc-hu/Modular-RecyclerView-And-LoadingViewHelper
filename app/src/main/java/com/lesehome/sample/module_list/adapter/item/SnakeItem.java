package com.lesehome.sample.module_list.adapter.item;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.carrot.recycler.modularadapter.impl.HListItemAdapter;
import com.lesehome.sample.model.entity.Snake;
import com.lesehome.sample.R;

import java.util.List;


public class SnakeItem extends HListItemAdapter<List<IItemEntity>> {

    private LayoutInflater inflater;

    public SnakeItem(Activity activity, int viewType) {
        super(viewType);
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<IItemEntity> items, int position) {
        return items.get(position) instanceof Snake;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HViewHolder(inflater.inflate(R.layout.sample_item_snake, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<IItemEntity> items, int position,
                                 @NonNull HViewHolder holder) {
        Snake snake = (Snake) items.get(position);
        holder.setTag(snake);

        holder.getTv(R.id.name).setText(snake.getName());
        holder.getTv(R.id.race).setText(snake.getRace());
    }

}
