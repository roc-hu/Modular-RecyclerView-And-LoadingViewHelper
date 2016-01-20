package com.lesehome.sample.module_mvc.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lesehome.carrot.loadingview.IDataAdapter;
import com.lesehome.carrot.loadingview.LoadingViewHelper;
import com.lesehome.carrot.loadingview.helper.LoadingViewNormalHelper;
import com.lesehome.sample.BaseActivity;
import com.lesehome.sample.R;
import com.lesehome.sample.module_mvc.model.NormalDataSource;
import com.lesehome.sample.module_mvc.model.entity.Book;

/**
 * 测试没有下拉刷新组件，LoadingViewNormalHelper
 */
public class NormalActivity extends BaseActivity {

    private LoadingViewHelper<Book> mvcHelper;
    private TextView authorTextView;
    private TextView contentTextView;
    private TextView descriptionTextView;
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_mvc_normal);

        View contentLayout = findView(R.id.content_layout);
        nameTextView = findView(R.id.name_textView);
        authorTextView = findView(R.id.author_textView);
        descriptionTextView = findView(R.id.description_textView);
        contentTextView = findView(R.id.content_textView);

        mvcHelper = new LoadingViewNormalHelper<>(contentLayout);

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
