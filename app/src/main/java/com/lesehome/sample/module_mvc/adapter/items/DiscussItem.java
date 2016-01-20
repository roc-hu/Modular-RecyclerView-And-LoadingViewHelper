package com.lesehome.sample.module_mvc.adapter.items;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.carrot.recycler.modularadapter.impl.HListItemAdapter;
import com.lesehome.sample.module_mvc.model.entity.Discuss;
import com.lesehome.sample.R;

import java.util.List;

/**
 * Created by hcp on 16/1/11.
 */
public class DiscussItem extends HListItemAdapter<List<IItemEntity>> {

    private LayoutInflater inflater;

    public DiscussItem(Activity activity, int viewType) {
        super(viewType);
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<IItemEntity> items, int position) {
        return items.get(position) instanceof Discuss;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HViewHolder(inflater.inflate(R.layout.item_example_mvc_discuss, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<IItemEntity> items, int position,
                                 @NonNull HViewHolder holder) {
        Discuss discuss = (Discuss) items.get(position);
        if(discuss !=null) {
            holder.setTag(discuss);
            holder.getTv(R.id.item_dicuss_content_textView).setText(discuss.getContent());
            holder.getTv(R.id.item_dicuss_user_textView).setText(discuss.getName());
            holder.getTv(R.id.item_dicuss_time_textView).setText(DateFormat.format("MM-dd HH:mm", discuss.getTime()));
        }
    }
}
