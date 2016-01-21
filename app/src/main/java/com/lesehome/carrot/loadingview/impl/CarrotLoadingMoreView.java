package com.lesehome.carrot.loadingview.impl;

import android.view.View;
import android.widget.TextView;

import com.lesehome.carrot.loadingview.ILoadViewFactory;
import com.lesehome.sample.R;

/**
 * Created by hcp on 16/1/21.
 */
public class CarrotLoadingMoreView implements ILoadViewFactory.ILoadMoreView {

    protected TextView footView;

    protected View.OnClickListener onClickRefreshListener;

    @Override
    public void init(ILoadViewFactory.FootViewAdder footViewHolder, View.OnClickListener onClickRefreshListener) {
        footView = (TextView) footViewHolder.addFootView(R.layout.carrot_loadingview_foot_more);
        this.onClickRefreshListener = onClickRefreshListener;
        showNormal();
    }

    @Override
    public void showNormal() {
        footView.setText("点击加载更多!");
        footView.setOnClickListener(onClickRefreshListener);
    }

    @Override
    public void showLoading() {
        footView.setText("正在加载中..");
        footView.setOnClickListener(null);
    }

    @Override
    public void showFail(Exception exception) {
        footView.setText("加载失败，点击重新加载!");
        footView.setOnClickListener(onClickRefreshListener);
    }

    @Override
    public void showNomore() {
        footView.setText("已经加载完毕!");
        footView.setOnClickListener(null);
    }

}