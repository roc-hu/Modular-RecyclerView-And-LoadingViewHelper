package com.lesehome.sample.module_sticky.controller;

import android.support.v7.widget.RecyclerView;

import com.lesehome.sample.module_sticky.adapter.DoubleHeaderTestAdapter;
import com.lesehome.carrot.recycler.decoration.DoubleHeaderDecoration;

public class DoubleHeaderFragment extends BaseDecorationFragment {

    private DoubleHeaderDecoration decor;

    @Override
    protected void setAdapterAndDecor(RecyclerView list) {
        final DoubleHeaderTestAdapter adapter = new DoubleHeaderTestAdapter(this.getActivity());
        decor = new DoubleHeaderDecoration(adapter);
        setHasOptionsMenu(true);

        list.setAdapter(adapter);
        list.addItemDecoration(decor, 1);

//        decor.clearDoubleHeaderCache();
    }
}
