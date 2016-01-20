package com.lesehome.carrot.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.decoration.StickyHeaderDecoration;

/**
 * The adapter to assist the {@link StickyHeaderDecoration} in creating and binding the header views.
 *
 * @param <T> the header view holder
 */
public interface StickyHeaderAdapter<T extends RecyclerView.ViewHolder> {

    /**
     * Returns the header id for the item at the given position.
     *
     * @param position the item position
     * @return the header id
     */
    long getHeaderId(int position);

    /**
     * Creates a new header ViewHolder.
     *
     * @param parent the header's view parent
     * @return a view holder for the created view
     */
    T onCreateHeaderViewHolder(ViewGroup parent);

    /**
     * Updates the header view to reflect the header data for the given position
     * @param viewholder the header view holder
     * @param position the header's item position
     */
    void onBindHeaderViewHolder(T viewholder, int position);
}
