package com.lesehome.sample.module_mvc.controller;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.lesehome.carrot.loadingview.LoadingViewHelper;
import com.lesehome.carrot.loadingview.helper.LoadingViewUltraHelper;
import com.lesehome.sample.module_mvc.adapter.TextViewAdapter;
import com.lesehome.sample.module_mvc.model.StringsDataSource;
import com.lesehome.sample.R;

/**
 * 测试下拉刷新组件，LoadingViewUltraHelper
 */
public class UltraRecyclerViewStaggeredActivity extends Activity {
    private LoadingViewHelper<List<String>> mvcHelper;

    private TextViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_mvc_ultrarecyclerview);

        PtrClassicFrameLayout mPtrFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.rotate_header_list_view_frame);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        mvcHelper = new LoadingViewUltraHelper<>(mPtrFrameLayout);
        // 设置数据源
        mvcHelper.setDataSource(new StringsDataSource());
        adapter = new TextViewAdapter(this);
        adapter.isGrid = true;
        // 设置适配器
        mvcHelper.setAdapter(adapter);

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
