package com.lesehome.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lesehome.carrot.recycler.modularadapter.IAdapterItem;
import com.lesehome.sample.adapter.MainAdapter;
import com.lesehome.sample.module_list.GridActivity;
import com.lesehome.sample.module_list.LinearActivity;
import com.lesehome.sample.module_list.StaggeredGridActivity;

import com.lesehome.sample.module_mvc.controller.NormalWithRefreshActivity;
import com.lesehome.sample.module_mvc.controller.UltraRecyclerViewGridActivity;
import com.lesehome.sample.module_mvc.controller.UltraRecyclerViewStaggeredActivity;
import com.lesehome.sample.module_sticky.StickyheadersActivity;
import com.lesehome.sample.module_mvc.controller.MovieDetailActivity;
import com.lesehome.sample.module_mvc.controller.NormalActivity;
import com.lesehome.sample.module_mvc.controller.SwipeRefreshActivity;
import com.lesehome.sample.module_mvc.controller.UltraRecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements IAdapterItem.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMainAdapter = new MainAdapter(this, getItems());
        mMainAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mMainAdapter);
    }

    @Override
    public void onItemClick(View view, int position, int itemViewType) {
        switch (position) {
            case 0://RecyclerView 列表
                startActivity(new Intent(this, LinearActivity.class));
                break;
            case 1://RecyclerView 网格
                startActivity(new Intent(this, GridActivity.class));
                break;
            case 2://RecyclerView 瀑布流
                startActivity(new Intent(this, StaggeredGridActivity.class));
                break;

            case 3://MVC 默认页面
                startActivity(new Intent(this, NormalActivity.class));
                break;
            case 4://MVC 带下拉刷新的页面
                startActivity(new Intent(this, NormalWithRefreshActivity.class));
                break;
            case 5://带下拉刷新的列表页面
                startActivity(new Intent(this, SwipeRefreshActivity.class));
                break;
            case 6:// Ultra的RecyclerView界面
                startActivity(new Intent(this, UltraRecyclerViewActivity.class));
                break;
            case 7://Ultra的Recycler Grid 界面
                startActivity(new Intent(this, UltraRecyclerViewGridActivity.class));
                break;
            case 8://Recycler Staggered 界面
                startActivity(new Intent(this, UltraRecyclerViewStaggeredActivity.class));
                break;
            case 9://超复杂的界面
                startActivity(new Intent(this, MovieDetailActivity.class));
                break;
            case 10://Stickyheaders
                startActivity(new Intent(this, StickyheadersActivity.class));
                break;
            case 11://
                break;
            default:
                break;
        }
    }

    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("RecyclerView 列表");
        items.add("RecyclerView 网格");
        items.add("RecyclerView 瀑布流");


        items.add("MVC 默认页面");
        items.add("MVC 带下拉刷新的页面");
        items.add("MVC SwipeRefresh列表页面");
        items.add("MVC Ultra的Recycler界面");
        items.add("MVC Ultra的Recycler Grid 界面");
        items.add("MVC Ultra的Recycler Staggered 界面");

        items.add("复杂列表布局，MovieList");
        items.add("Stickyheaders");

        return items;
    }

}
