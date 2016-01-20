package com.lesehome.sample.module_mvc.controller;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.MaterialHeader;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.lesehome.carrot.loadingview.LoadingViewHelper;
import com.lesehome.carrot.loadingview.helper.LoadingViewUltraHelper;
import com.lesehome.sample.module_mvc.model.StringsDataSource;
import com.lesehome.sample.module_mvc.adapter.TextViewAdapter;
import com.lesehome.sample.R;

/***
 * 测试下拉组件的简单的列表界面，LoadingViewUltraHelper，RecyclerView
 */
public class UltraRecyclerViewActivity extends Activity {
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

        final MaterialHeader header = new MaterialHeader(getApplicationContext());
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, dipToPix(getApplicationContext(), 15), 0, dipToPix(getApplicationContext(), 10));
        header.setPtrFrameLayout(mPtrFrameLayout);
        mPtrFrameLayout.setLoadingMinTime(800);
        mPtrFrameLayout.setDurationToCloseHeader(800);
        mPtrFrameLayout.setHeaderView(header);
        mPtrFrameLayout.addPtrUIHandler(header);

        mvcHelper = new LoadingViewUltraHelper<>(mPtrFrameLayout);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TextViewAdapter(this);
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

    /**
     * 根据dip值转化成px值
     *
     * @param context
     * @param dip
     * @return
     */
    public static int dipToPix(Context context, int dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics());
        return size;
    }
}
