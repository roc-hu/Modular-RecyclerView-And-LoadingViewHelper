package com.lesehome.sample.module_mvc.controller;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lesehome.sample.widget.PtrHeader;
import com.lesehome.carrot.loadingview.LoadingViewHelper;
import com.lesehome.carrot.loadingview.helper.LoadingViewUltraHelper;
import com.lesehome.carrot.loadingview.data.Data3;
import com.lesehome.carrot.recycler.modularadapter.IAdapterItem;
import com.lesehome.sample.module_mvc.model.entity.Other;
import com.lesehome.sample.module_mvc.model.MovieDetailDataSource;
import com.lesehome.sample.module_mvc.model.entity.Discuss;
import com.lesehome.sample.module_mvc.model.entity.Movie;
import com.lesehome.sample.module_mvc.adapter.MovieDetailAdapter;
import com.lesehome.sample.R;

/***
 * 测试下拉组件的超复杂的列表界面，LoadingViewUltraHelper，RecyclerView
 *
 */
public class MovieDetailActivity extends Activity implements IAdapterItem.OnItemClickListener{

    private LoadingViewHelper<Data3<Movie, List<Discuss>, List<Other>>> listViewHelper;

    private MovieDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_mvc_moviedetail);

        PtrClassicFrameLayout contentLayout = (PtrClassicFrameLayout) findViewById(R.id.rotate_header_list_view_frame);

        final PtrHeader header = new PtrHeader(this);
        header.setLastUpdateTimeKey("hcp");
        contentLayout.setHeaderView(header);
        contentLayout.addPtrUIHandler(header);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


		recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listViewHelper = new LoadingViewUltraHelper<>(contentLayout);

        // 设置数据源
        listViewHelper.setDataSource(new MovieDetailDataSource());
        adapter = new MovieDetailAdapter(this);
        adapter.setOnItemClickListener(this);
        // 设置适配器
        listViewHelper.setAdapter(adapter);

        // 加载数据
        listViewHelper.refresh();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 释放资源
        listViewHelper.destory();
    }

    public void onClickBack(View view) {
        finish();
    }

    @Override
    public void onItemClick(View view, int position, int itemViewType) {
        Toast.makeText(this, "position:"+position, Toast.LENGTH_SHORT).show();
    }
}
