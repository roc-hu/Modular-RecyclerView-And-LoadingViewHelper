package com.lesehome.carrot.loadingview;

import android.view.View;
import android.view.View.OnClickListener;

import com.lesehome.carrot.loadingview.ILoadViewFactory.ILoadMoreView;
import com.lesehome.carrot.loadingview.LoadingViewHelper.OnScrollBottomListener;

public interface IViewHandler {

    /**
     * @param contentView
     * @param adapter
     * @param loadMoreView
     * @param onClickLoadMoreListener
     * @return 是否有 init ILoadMoreView
     */
    boolean handleSetAdapter(View contentView, IDataAdapter<?> adapter, ILoadMoreView loadMoreView, OnClickListener onClickLoadMoreListener);

    void setOnScrollBottomListener(View contentView, OnScrollBottomListener onScrollBottomListener);

}
