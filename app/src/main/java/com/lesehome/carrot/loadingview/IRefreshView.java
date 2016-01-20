package com.lesehome.carrot.loadingview;

import android.view.View;

public interface IRefreshView {

    /**
     * 内容布局
     *
     * @return
     */
    View getContentView();

    /**
     * 通过替换这个View实现切换失败，成功，无数据布局
     *
     * @return
     */
    View getSwitchView();

    /**
     * 设置刷新事件
     *
     * @param onRefreshListener
     */
    void setOnRefreshListener(OnRefreshListener onRefreshListener);

    /**
     * 显示刷新完成
     */
    void showRefreshComplete();

    /**
     * 显示正在刷新
     */
    void showRefreshing();

    /**
     * 刷新监听
     *
     * @author LuckyJayce
     */
    interface OnRefreshListener {
        void onRefresh();
    }

}
