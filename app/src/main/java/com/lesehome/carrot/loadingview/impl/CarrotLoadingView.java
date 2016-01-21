package com.lesehome.carrot.loadingview.impl;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lesehome.carrot.loadingview.ILoadViewFactory;
import com.lesehome.carrot.loadingview.helper.VaryViewHelper;
import com.lesehome.sample.R;

/**
 * Created by hcp on 16/1/21.
 */
public class CarrotLoadingView implements ILoadViewFactory.ILoadView {
    private VaryViewHelper helper;
    private View.OnClickListener onClickRefreshListener;
    private Context context;

    @Override
    public void init(View switchView, View.OnClickListener onClickRefreshListener) {
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
        View layout = helper.inflate(R.layout.carrot_loadingview_ing);
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
        View layout = helper.inflate(R.layout.carrot_loadingview_error);
        TextView textView = (TextView) layout.findViewById(R.id.textView1);
        textView.setText("网络加载失败");
        Button button = (Button) layout.findViewById(R.id.button1);
        button.setText("重试");
        button.setOnClickListener(onClickRefreshListener);
        helper.showLayout(layout);
    }

    @Override
    public void showEmpty() {
        View layout = helper.inflate(R.layout.carrot_loadingview_empty);
        TextView textView = (TextView) layout.findViewById(R.id.textView1);
        textView.setText("暂无数据");
        Button button = (Button) layout.findViewById(R.id.button1);
        button.setText("重试");
        button.setOnClickListener(onClickRefreshListener);
        helper.showLayout(layout);
    }

}