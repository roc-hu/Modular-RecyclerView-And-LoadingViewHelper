package com.lesehome.carrot.loadingview.viewHander;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class LVAdapter extends RecyclerView.Adapter {

    public static final int TYPE_FOOTER = 7899;

    private View mFooter = null;

    public abstract RecyclerView.ViewHolder onCreateViewHolderHF(ViewGroup viewGroup, int type);

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        if (type == TYPE_FOOTER) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new HeaderFooterViewHolder(frameLayout);
        } else {
            return onCreateViewHolderHF(viewGroup, type);
        }
    }

    @Override
    public final void onBindViewHolder(final RecyclerView.ViewHolder vh, int position) {
        if (isFooter(position)) {
            prepareFooter((HeaderFooterViewHolder) vh);
        } else {
            onBindViewHolderHF(vh, position);
        }
    }

    public abstract void onBindViewHolderHF(ViewHolder vh, int position);

    private void prepareFooter(HeaderFooterViewHolder vh) {

        StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setFullSpan(true);
        vh.itemView.setLayoutParams(layoutParams);

        if (mFooter != null) {
            // if the view already belongs to another layout, remove it
            if (mFooter.getParent() != null) {
                ((ViewGroup) mFooter.getParent()).removeView(mFooter);
            }

            // empty out our FrameLayout and replace with our header/footer
            vh.base.removeAllViews();
            vh.base.addView(mFooter);
        }
    }

    private boolean isFooter(int position) {
        return (position >= getItemCountHF());
    }

    @Override
    public final int getItemCount() {
        return getItemCountHF() + (mFooter != null ? 1 : 0);
    }

    public abstract int getItemCountHF();

    @Override
    public final int getItemViewType(int position) {
        // check what type our position is, based on the assumption that the
        // order is headers > items > footers
        if (isFooter(position)) {
            return TYPE_FOOTER;
        }
        int type = getItemViewTypeHF(position);
        if (type == TYPE_FOOTER) {
            throw new IllegalArgumentException("Item type cannot equal " + TYPE_FOOTER);
        }
        return type;
    }

    public int getItemViewTypeHF(int position) {
        return super.getItemViewType(position);
    }

    // add a footer to the adapter
    public void addFooter(View footer) {
        removeFooter();
        if (mFooter == null) {
            mFooter = footer;
            // animate
            notifyItemInserted(getItemCountHF() - 1);
        }
    }

    // remove a footer from the adapter
    public void removeFooter() {
        if (mFooter != null) {
            // animate
            notifyItemRemoved(getItemCountHF());
            mFooter = null;
        }
    }

    // our footer RecyclerView.ViewHolder is just a FrameLayout
    public static class HeaderFooterViewHolder extends RecyclerView.ViewHolder {
        FrameLayout base;

        public HeaderFooterViewHolder(View itemView) {
            super(itemView);
            base = (FrameLayout) itemView;
        }
    }
}
