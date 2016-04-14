package com.lesehome.carrot.loadingview;

import android.view.View.OnClickListener;

import com.lesehome.carrot.loadingview.ILoadViewFactory.ILoadMoreView;
import com.lesehome.carrot.loadingview.LoadingViewHelper.OnScrollBottomListener;

public interface IViewHandler<ContentView> {

    /**
     * @param contentView             ListView or RecyclerView
     * @param adapter
     * @param loadMoreView
     * @param onClickLoadMoreListener
     * @return 是否有 init ILoadMoreView
     */
    boolean handleSetAdapter(ContentView contentView, IDataAdapter<?> adapter,
                             ILoadMoreView loadMoreView, OnClickListener onClickLoadMoreListener);

    void setOnScrollBottomListener(ContentView contentView, OnScrollBottomListener onScrollBottomListener);

}
