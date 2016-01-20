package com.lesehome.sample.module_mvc.controller;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lesehome.carrot.loadingview.LoadingViewHelper;
import com.lesehome.carrot.loadingview.helper.LoadIngViewSwipeRefreshHelper;
import com.lesehome.sample.module_mvc.adapter.TextViewAdapter;
import com.lesehome.sample.R;
import com.lesehome.sample.module_mvc.model.StringsAsyncDataSource;
import com.lesehome.sample.module_mvc.model.StringsVolleyDataSource;

/**
 * 测试下拉刷新组件，LoadIngViewSwipeRefreshHelper
 */
public class SwipeRefreshActivity extends Activity {

    private LoadingViewHelper<List<String>> mvcHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_mvc_swiperefresh);

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mvcHelper = new LoadIngViewSwipeRefreshHelper<>(swipeRefreshLayout);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // 设置数据源
//        mvcHelper.setDataSource(new StringsDataSource());
//        mvcHelper.setDataSource(new StringsVolleyDataSource());
        mvcHelper.setDataSource(new StringsAsyncDataSource());
        // 设置适配器
        mvcHelper.setAdapter(new TextViewAdapter(this));

        // 加载数据
        mvcHelper.refresh();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 释放资源
        mvcHelper.destory();
    }

}
