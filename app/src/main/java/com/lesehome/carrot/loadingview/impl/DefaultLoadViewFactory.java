package com.lesehome.carrot.loadingview.impl;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lesehome.carrot.loadingview.ILoadViewFactory;
import com.lesehome.carrot.loadingview.helper.VaryViewHelper;
import com.lesehome.sample.R;

public class DefaultLoadViewFactory implements ILoadViewFactory {

    @Override
    public ILoadMoreView madeLoadMoreView() {
        return new LoadMoreHelper();
    }

    @Override
    public ILoadView madeLoadView() {
        return new LoadViewHelper();
    }

    private class LoadMoreHelper implements ILoadMoreView {

        protected TextView footView;

        protected OnClickListener onClickRefreshListener;

        @Override
        public void init(FootViewAdder footViewHolder, OnClickListener onClickRefreshListener) {
            footView = (TextView) footViewHolder.addFootView(R.layout.carrot_mvc_layout_listview_foot);
            this.onClickRefreshListener = onClickRefreshListener;
            showNormal();
        }

        @Override
        public void showNormal() {
            footView.setText("点击加载更多");
            footView.setOnClickListener(onClickRefreshListener);
        }

        @Override
        public void showLoading() {
            footView.setText("正在加载中..");
            footView.setOnClickListener(null);
        }

        @Override
        public void showFail(Exception exception) {
            footView.setText("加载失败，点击重新加载");
            footView.setOnClickListener(onClickRefreshListener);
        }

        @Override
        public void showNomore() {
            footView.setText("已经加载完毕");
            footView.setOnClickListener(null);
        }

    }

    private class LoadViewHelper implements ILoadView {
        private VaryViewHelper helper;
        private OnClickListener onClickRefreshListener;
        private Context context;

        @Override
        public void init(View switchView, OnClickListener onClickRefreshListener) {
            this.context = switchView.getContext().getApplicationContext();
            this.onClickRefreshListener = onClickRefreshListener;
            helper = new VaryViewHelper(switchView);
        }

        @Override
        public void restore() {
            helper.restoreView();
        }

        @Override
        public void showLoading() {
            View layout = helper.inflate(R.layout.carrot_mvc_load_ing);
            TextView textView = (TextView) layout.findViewById(R.id.textView1);
            textView.setText("加载中...");
            helper.showLayout(layout);
        }

        @Override
        public void tipFail(Exception exception) {
            Toast.makeText(context, "网络加载失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showFail(Exception exception) {
            View layout = helper.inflate(R.layout.carrot_mvc_load_error);
            TextView textView = (TextView) layout.findViewById(R.id.textView1);
            textView.setText("网络加载失败");
            Button button = (Button) layout.findViewById(R.id.button1);
            button.setText("重试");
            button.setOnClickListener(onClickRefreshListener);
            helper.showLayout(layout);
        }

        @Override
        public void showEmpty() {
            View layout = helper.inflate(R.layout.carrot_mvc_load_empty);
            TextView textView = (TextView) layout.findViewById(R.id.textView1);
            textView.setText("暂无数据");
            Button button = (Button) layout.findViewById(R.id.button1);
            button.setText("重试");
            button.setOnClickListener(onClickRefreshListener);
            helper.showLayout(layout);
        }

    }
}
