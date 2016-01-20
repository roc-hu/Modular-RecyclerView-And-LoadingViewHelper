package com.lesehome.sample.module_mvc.controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.lesehome.carrot.loadingview.IDataAdapter;
import com.lesehome.carrot.loadingview.LoadingViewHelper;
import com.lesehome.carrot.loadingview.helper.LoadIngViewSwipeRefreshHelper;
import com.lesehome.sample.R;
import com.lesehome.sample.module_mvc.model.entity.Book;
import com.lesehome.sample.module_mvc.model.NormalDataSource;

/**
 * 测试下拉组件的非列表界面，LoadingViewNormalHelper
 */
public class NormalWithRefreshActivity extends Activity {

    private LoadingViewHelper<Book> mvcHelper;
    private TextView authorTextView;
    private TextView contentTextView;
    private TextView descriptionTextView;
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_mvc_normal_with_refresh);

        nameTextView = (TextView) findViewById(R.id.name_textView);
        authorTextView = (TextView) findViewById(R.id.author_textView);
        descriptionTextView = (TextView) findViewById(R.id.description_textView);
        contentTextView = (TextView) findViewById(R.id.content_textView);

        // 设置LoadView的factory，用于创建使用者自定义的加载失败，加载中，加载更多等布局,写法参照DeFaultLoadViewFactory
        // ListViewHelper.setLoadViewFactory(new LoadViewFactory());
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        mvcHelper = new LoadIngViewSwipeRefreshHelper<>(swipeRefreshLayout);

        // 设置数据源
        mvcHelper.setDataSource(new NormalDataSource());
        // 设置适配器
        mvcHelper.setAdapter(dataAdapter);

        // 加载数据
        mvcHelper.refresh();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 释放资源
        mvcHelper.destory();
    }

    private IDataAdapter<Book> dataAdapter = new IDataAdapter<Book>() {
        private Book data;

        @Override
        public void notifyDataChanged(Book data, boolean isRefresh) {
            this.data = data;
            authorTextView.setText(data.getAuthor());
            contentTextView.setText(data.getContent());
            descriptionTextView.setText(data.getDescription());
            nameTextView.setText(data.getName());
        }

        @Override
        public boolean isEmpty() {
            return data == null;
        }

        @Override
        public Book getData() {
            return data;
        }
    };
}