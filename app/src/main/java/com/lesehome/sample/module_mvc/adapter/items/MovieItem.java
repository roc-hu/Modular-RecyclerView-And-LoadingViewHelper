package com.lesehome.sample.module_mvc.adapter.items;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.modularadapter.impl.HViewHolder;
import com.lesehome.carrot.recycler.modularadapter.impl.HListItemAdapter;
import com.lesehome.sample.module_mvc.model.entity.Movie;
import com.lesehome.sample.R;

import java.util.List;

/**
 * Created by hcp on 16/1/11.
 */
public class MovieItem extends HListItemAdapter<List<IItemEntity>> {

    private LayoutInflater inflater;

    public MovieItem(Activity activity, int viewType) {
        super(viewType);
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<IItemEntity> items, int position) {
        return items.get(position) instanceof Movie;
    }

    @NonNull
    @Override
    public HViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HViewHolder(inflater.inflate(R.layout.item_example_mvc_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<IItemEntity> items, int position,
                                 @NonNull HViewHolder holder) {
        Movie movie = (Movie) items.get(position);
        if (movie != null) {
            holder.setTag(movie);
            holder.getTv(R.id.item_movie_description_textView).setText(movie.getDescription());
            holder.getTv(R.id.item_movie_name_textView).setText(movie.getName());
            holder.getTv(R.id.item_movie_time_textView).setText(movie.getTime());
        }
    }
}
