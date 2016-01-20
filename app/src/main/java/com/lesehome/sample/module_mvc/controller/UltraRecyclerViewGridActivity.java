package com.lesehome.sample.module_mvc.controller;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lesehome.carrot.loadingview.LoadingViewHelper;
import com.lesehome.carrot.loadingview.helper.LoadingViewUltraHelper;
import com.lesehome.sample.module_mvc.adapter.TextViewAdapter;
import com.lesehome.sample.R;
import com.lesehome.sample.module_mvc.model.StringsDataSource;

import java.util.List;

/***
 * 测试下拉组件的非列表界面
 */
public class UltraRecyclerViewGridActivity extends Activity {
    private LoadingViewHelper<List<String>> mvcHelper;

    private PtrClassicFrameLayout mPtrFrameLayout;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mManager;

    private TextViewAdapter adapter;
    private StringsDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_mvc_ultrarecyclerview);

        mPtrFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.rotate_header_list_view_frame);
        mvcHelper = new LoadingViewUltraHelper<>(mPtrFrameLayout);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mManager);

        adapter = new TextViewAdapter(this);
        adapter.isGrid = true;
        dataSource = new StringsDataSource();

        // 设置数据源
        mvcHelper.setDataSource(dataSource);
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
