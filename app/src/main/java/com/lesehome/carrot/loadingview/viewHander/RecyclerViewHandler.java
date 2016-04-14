package com.lesehome.carrot.loadingview.viewHander;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import com.lesehome.carrot.loadingview.ILoadViewFactory.FootViewAdder;
import com.lesehome.carrot.loadingview.ILoadViewFactory.ILoadMoreView;
import com.lesehome.carrot.loadingview.LoadingViewHelper.OnScrollBottomListener;
import com.lesehome.carrot.loadingview.IDataAdapter;
import com.lesehome.carrot.loadingview.IViewHandler;

public class RecyclerViewHandler implements IViewHandler<RecyclerView> {

    @Override
    public boolean handleSetAdapter(RecyclerView contentView, IDataAdapter<?> adapter, ILoadMoreView loadMoreView, OnClickListener onClickLoadMoreListener) {
        boolean hasInit = false;
        Adapter<?> adapter2 = (Adapter<?>) adapter;
        if (loadMoreView != null) {
            final LVAdapter hfAdapter;
            if (adapter instanceof LVAdapter) {
                hfAdapter = (LVAdapter) adapter;
            } else {
                hfAdapter = new LVRecyclerAdapter(adapter2);
            }
            adapter2 = hfAdapter;
            loadMoreView.init(new RecyclerViewFootViewAdder(contentView, hfAdapter), onClickLoadMoreListener);
            hasInit = true;
        }
        contentView.setAdapter(adapter2);
        return hasInit;
    }

    @Override
    public void setOnScrollBottomListener(RecyclerView contentView, OnScrollBottomListener onScrollBottomListener) {
        contentView.addOnScrollListener(new RecyclerViewOnScrollListener(onScrollBottomListener));
    }

    /**
     * 滑动监听
     */
    private static class RecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {
        private OnScrollBottomListener onScrollBottomListener;

        public RecyclerViewOnScrollListener(OnScrollBottomListener onScrollBottomListener) {
            super();
            this.onScrollBottomListener = onScrollBottomListener;
        }

        @Override
        public void onScrollStateChanged(android.support.v7.widget.RecyclerView recyclerView, int newState) {
            if (newState == RecyclerView.SCROLL_STATE_IDLE && isScollBottom(recyclerView)) {
                if (onScrollBottomListener != null) {
                    onScrollBottomListener.onScorllBootom();
                }
            }
        }

        private boolean isScollBottom(RecyclerView recyclerView) {
            return !isCanScollVertically(recyclerView);
        }

        private boolean isCanScollVertically(RecyclerView recyclerView) {
            if (android.os.Build.VERSION.SDK_INT < 14) {
                return ViewCompat.canScrollVertically(recyclerView, 1) || recyclerView.getScrollY() < recyclerView.getHeight();
            } else {
                return ViewCompat.canScrollVertically(recyclerView, 1);
            }
        }

        @Override
        public void onScrolled(android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {

        }

    }

    private class RecyclerViewFootViewAdder implements FootViewAdder {
        private RecyclerView recyclerView;
        private LVAdapter hfAdapter;

        public RecyclerViewFootViewAdder(RecyclerView recyclerView, LVAdapter hfAdapter) {
            super();
            this.recyclerView = recyclerView;
            this.hfAdapter = hfAdapter;
        }

        @Override
        public View addFootView(int layoutId) {
            View view = LayoutInflater.from(recyclerView.getContext()).inflate(layoutId, recyclerView, false);
            return addFootView(view);
        }

        @Override
        public View addFootView(View view) {
            hfAdapter.addFooter(view);
            return view;
        }

        @Override
        public View getContentView() {
            return recyclerView;
        }

    }
}
