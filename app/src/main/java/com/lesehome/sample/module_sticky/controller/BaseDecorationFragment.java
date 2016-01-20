package com.lesehome.sample.module_sticky.controller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lesehome.carrot.recycler.decoration.LinearDividerItemDecoration;
import com.lesehome.sample.R;

public abstract class BaseDecorationFragment extends Fragment {

    private RecyclerView mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.stickyheaders_fragment_recycler, container, false);

        mList = (RecyclerView) view.findViewById(R.id.list);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearDividerItemDecoration itemDecoration = new LinearDividerItemDecoration.Builder(getActivity())
                .color(Color.RED)
                .sizeResId(R.dimen.default_divider_height)
                .marginResId(R.dimen.default_divider_leftmargin, R.dimen.default_divider_rightmargin)
                .build();

        //测试
        mList.addItemDecoration(itemDecoration);

        mList.setHasFixedSize(true);
        mList.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        setAdapterAndDecor(mList);
    }

    protected abstract void setAdapterAndDecor(RecyclerView list);

}
