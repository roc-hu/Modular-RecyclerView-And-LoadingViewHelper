package com.lesehome.carrot.loadingview;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 布局切换工厂
 */
public interface ILoadViewFactory {

    ILoadMoreView madeLoadMoreView();

    ILoadView madeLoadView();

    /**
     * 切换加载中，加载失败等布局
     */
    interface ILoadView {

        /**
         * 初始化
         *
         * @param onClickRefreshListener ，刷新的点击事件，需要点击刷新的按钮都可以设置这个监听
         */
        void init(View switchView, OnClickListener onClickRefreshListener);

        /**
         * 显示加载中
         */
        void showLoading();

        /**
         * 显示加载失败
         *
         * @param e
         */
        void showFail(Exception e);

        /**
         * 显示空数据布局
         */
        void showEmpty();

        /**
         * 有数据的时候，toast提示失败
         *
         * @param e
         */
        void tipFail(Exception e);

        /**
         * 显示原先的布局
         */
        void restore();

    }

    /**
     * ListView底部加载更多的布局切换
     *
     */
    interface ILoadMoreView {

        /**
         * 初始化
         *
         * @param onClickLoadMoreListener 加载更多的点击事件，需要点击调用加载更多的按钮都可以设置这个监听
         */
        void init(FootViewAdder footViewHolder, OnClickListener onClickLoadMoreListener);

        /**
         * 显示普通保布局
         */
        void showNormal();

        /**
         * 显示已经加载完成，没有更多数据的布局
         */
        void showNomore();

        /**
         * 显示正在加载中的布局
         */
        void showLoading();

        /**
         * 显示加载失败的布局
         *
         * @param e
         */
        void showFail(Exception e);

    }

    interface FootViewAdder {

        View addFootView(View view);

        View addFootView(int layoutId);

        View getContentView();

    }

}