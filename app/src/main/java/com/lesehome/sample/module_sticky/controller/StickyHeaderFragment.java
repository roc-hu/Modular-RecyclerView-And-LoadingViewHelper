package com.lesehome.sample.module_sticky.controller;

import android.support.v7.widget.RecyclerView;

import com.lesehome.sample.module_sticky.adapter.StickyTestAdapter;
import com.lesehome.carrot.recycler.decoration.StickyHeaderDecoration;

public class StickyHeaderFragment extends BaseDecorationFragment {

    private StickyHeaderDecoration decor;

    @Override
    protected void setAdapterAndDecor(RecyclerView list) {
        final StickyTestAdapter adapter = new StickyTestAdapter(this.getActivity());
        decor = new StickyHeaderDecoration(adapter);
        setHasOptionsMenu(true);

        list.setAdapter(adapter);
        list.addItemDecoration(decor, 1);
    }

    @Override
    public void onDestroy() {
        decor.clearHeaderCache();
        super.onDestroy();
    }

}
